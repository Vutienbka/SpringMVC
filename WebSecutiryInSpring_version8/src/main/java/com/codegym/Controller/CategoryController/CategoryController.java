package com.codegym.Controller.CategoryController;

import com.codegym.Entity.Categories;
import com.codegym.Service.CategoriesService.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class CategoryController {

    @Autowired
    ICategoriesService categoriesService;

//    @RequestMapping(value = "/category-list",method = RequestMethod.GET)
//    public String gotoHomepage(){
//        return "admin/Category/CategoryList";
//    }

    @RequestMapping(value = "/category-list",method = RequestMethod.GET)
    public ModelAndView listProvinces(){
        ModelAndView modelAndView = new ModelAndView("admin/Category/CategoryList");
        List<Categories> categoryList = categoriesService.findAll();
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }

    @RequestMapping(value = "/add-category",method = RequestMethod.GET)
    public ModelAndView addCategoryForm(){
        ModelAndView modelAndView = new ModelAndView("admin/Category/AddCategory");
        modelAndView.addObject("category",new Categories());
        modelAndView.addObject("message","");
        return modelAndView;
    }

    @RequestMapping(value = "/add-category",method = RequestMethod.POST)
    public ModelAndView addCategory(@ModelAttribute("category") Categories newCategory){
        ModelAndView modelAndView = new ModelAndView("admin/Category/AddCategory");
        Categories category =  categoriesService.save(newCategory);
        modelAndView.addObject("category",category);
        if (category!=null)
            modelAndView.addObject("message","Add category successfully");

        return modelAndView;
    }

    @RequestMapping(value="/edit-category/{id}",method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("id") Long categoryId){
        Categories category = categoriesService.findById(categoryId);
        ModelAndView modelAndView;
        if(category!=null){
            modelAndView = new ModelAndView("admin/Category/EditCategory");
            modelAndView.addObject("category",category);
            return modelAndView;
        }else {
            modelAndView = new ModelAndView("admin/Category/error404");
            return modelAndView;
        }
    }
    @RequestMapping(value = "/edit-category",method = RequestMethod.POST)
    public ModelAndView editProvince(@ModelAttribute Categories category){
        categoriesService.save(category);
        ModelAndView modelAndView = new ModelAndView("admin/Category/EditCategory");
        modelAndView.addObject("message","Edit successful");
        modelAndView.addObject("category",category);
        return modelAndView;
    }

    @GetMapping(value = "/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long categoryId){
        Categories category = categoriesService.findById(categoryId);
        ModelAndView modelAndView;
        if(category != null) {
            modelAndView = new ModelAndView("admin/Category/DeleteCategory");
            modelAndView.addObject("category", category);
            return modelAndView;
        }else {
            modelAndView = new ModelAndView("admin/Category/error404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-category")
    public String deleteProvince(@ModelAttribute Categories category){
        categoriesService.remove(category.getId());
        return "redirect:/admin/category-list";
    }

    @GetMapping(value = "/view-category/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long categoryId){
        Categories category = categoriesService.findById(categoryId);
        ModelAndView modelAndView = new ModelAndView("admin/Category/ViewCategory");
        modelAndView.addObject("category",category);
        return modelAndView;
    }


}
