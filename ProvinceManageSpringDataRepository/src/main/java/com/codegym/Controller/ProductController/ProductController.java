package com.codegym.Controller.ProductController;

import com.codegym.Model.Item;
import com.codegym.Model.MyCart;
import com.codegym.Model.Product;
import com.codegym.Model.ProductPattern;
import com.codegym.Service.ProductService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

@Controller
@PropertySource("classpath:configApp.properties")
//@SessionAttributes("myCart")
public class ProductController {

    @Autowired
    Environment environment;

//    @Autowired
//    HttpSession session;

    /* add MyCounter in model attribute */
//    @ModelAttribute("myCart")
//    public MyCart setUpMyCart() {
//        return new MyCart();
//    }

    IProductService productService;

    ProductController(IProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "products")
    public ModelAndView listProduct() {
        ModelAndView modelAndView = new ModelAndView("Product/productList");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @GetMapping(value = "create-product")
    public ModelAndView productCreateForm() {
        ModelAndView modelAndView = new ModelAndView("Product/createProduct");
        modelAndView.addObject("productPattern", new ProductPattern());
        modelAndView.addObject("message", "");
        return modelAndView;
    }

    @PostMapping("save-product")
    public String addProduct(@ModelAttribute ProductPattern productPattern, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors();
        }

        MultipartFile multipartFile = productPattern.getProductImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = environment.getProperty("file_upload").toString();
        // luu file len server
        try {
            //multipartFile.transferTo(imageFile);
            FileCopyUtils.copy(productPattern.getProductImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Add product vao co so du lieu
        Product product = new Product(fileName, productPattern.getProductName(),
                productPattern.getProductPrice(), productPattern.getProductQuantity(), productPattern.getProductDescription());
        productService.save(product);

        return "redirect:/products";
    }

    @RequestMapping(value = "/add-cart/{id}")
    public ModelAndView addCart(@PathVariable("id") Long productId, @ModelAttribute("myCart") MyCart myCart, HttpSession session, Model model) {
        Double quantity = 1.0;
        ModelAndView modelAndView;
        Product product = productService.findById(productId);
        String pathOfFolder = "/home/vutienbka/Downloads/ImageServer/";
        myCart = (MyCart) session.getAttribute("myCart");
        if (product != null) {
            if (product.getProductQuantity() != 0) {
                if (myCart == null) {
                    myCart = new MyCart();
                    List<Item> itemList = new ArrayList<>();
                    Item item = new Item();
                    item.setProduct(product);
                    item.setPrice(product.getProductPrice());
                    item.setQuantity(quantity);
                    itemList.add(item);
                    myCart.setItemList(itemList);
                    session.setAttribute("myCart", myCart);
                    model.addAttribute("myCart", myCart);
                } else {
                    myCart = (MyCart) session.getAttribute("myCart");
                    List<Item> itemList = myCart.getItemList();
                    boolean check = false;
                    for (Item item : itemList) {
                        if (item.getProduct().getId() == product.getId()) {
                            item.setQuantity(item.getQuantity() + quantity);
                            check = true;
                        }
                    }
                    if (check == false) {
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setProduct(product);
                        item.setPrice(product.getProductPrice());
                        itemList.add(item);
                    }
                    session.setAttribute("myCart", myCart);
                    model.addAttribute("myCart", myCart);
                    model.addAttribute("folderPath",folderPath);
                }

            }
             modelAndView = new ModelAndView("Product/myCart");
            return modelAndView;

        } else {
             modelAndView = new ModelAndView("Product/myCart");
            return modelAndView;
        }
    }
    /*Download File*/
    String folderPath = "/home/vutienbka/Downloads/ImageServer/";

    @RequestMapping(value = "showFiles")
    public String showFiles(Model model){
        File folder = new File(folderPath);
        File[] listOfFile=folder.listFiles();
        model.addAttribute("fileList",listOfFile);
        return "FileDownload/fileList";
    }

    @RequestMapping(value = "/file/{fileName}")
    @ResponseBody
    public void show(@PathVariable("fileName") String fileName, HttpServletResponse response){
        if(fileName.indexOf(".jpg")>-1) response.setContentType("application/image");
        if(fileName.indexOf(".zip")>-1) response.setContentType("application/zip");

        response.setHeader("Content-Disposition","attachment; filename=" + fileName);
        response.setHeader("Content-Transfer-Encoding","binary");
        try{
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis  = new FileInputStream(folderPath+fileName);
            int len;
            byte[] buf = new byte[1024];
            while ((len=fis.read(buf))>0){
                bos.write(buf,0,len);
            }

            bos.close();
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
