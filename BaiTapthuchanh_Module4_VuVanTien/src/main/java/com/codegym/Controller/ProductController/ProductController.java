package com.codegym.Controller.ProductController;

import com.codegym.Entity.Category;
import com.codegym.Entity.Product;
import com.codegym.Service.CategoryService.ICategoryService;
import com.codegym.Service.ProductService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ICategoryService categoryService;

    @ModelAttribute("categoryList")
    public List<Category> categoryList(){
        return categoryService.getAllCategory();
    }

    @GetMapping(value = "/productList")
    public ModelAndView listCategory(){
        ModelAndView modelAndView = new ModelAndView("Product/list");
        List<Product> productList = productService.getAllProduct();
        modelAndView.addObject("productList",productList);
        return modelAndView;
    }

    @GetMapping(value = "/productAdd")
    public ModelAndView productAddForm(){
        ModelAndView modelAndView = new ModelAndView("Product/add");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping(value = "/productAdd")
    public ModelAndView productAdd(@ModelAttribute("product") Product product){
        ModelAndView modelAndView = new ModelAndView("Product/add");
        Product newProduct = productService.addProduct(product);
        if(newProduct!=null)
            modelAndView.addObject("message","Add successfully");
            modelAndView.addObject("product",newProduct);
        return modelAndView;
    }

}
