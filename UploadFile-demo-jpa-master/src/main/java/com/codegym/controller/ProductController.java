package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.ProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:global_config_app.properties")
public class ProductController {

    @Autowired
    Environment env;

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ModelAndView showProducts(){

        List<Product> products = productService.findAll();

        ModelAndView modelAndView = new ModelAndView("/products/index");
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView createProduct() {
        ModelAndView modelAndView = new ModelAndView("/products/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save-product")
    public ModelAndView saveProduct(@ModelAttribute("productForm") ProductForm productForm, BindingResult result) {

        // thong bao neu xay ra loi
        if (result.hasErrors()) {
            System.out.println("Result Error Occured" + result.getAllErrors());
        }

        // lay ten file
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        // luu file len server
        try {
            //multipartFile.transferTo(imageFile);
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // tham khảo: https://github.com/codegym-vn/spring-static-resources

        // tao doi tuong de luu vao db
        Product productObject = new Product(fileName, productForm.getName(), productForm.getPrice(), productForm.getQuantity(), productForm.getDescription());

        // luu vao db
        //productService.save(productObject);
        productService.add(productObject);

        ModelAndView modelAndView = new ModelAndView("/products/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
}
