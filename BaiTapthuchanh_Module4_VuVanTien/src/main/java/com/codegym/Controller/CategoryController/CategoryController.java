package com.codegym.Controller.CategoryController;

import com.codegym.Entity.Category;
import com.codegym.Service.CategoryService.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {

@Autowired
    ICategoryService categoryService;

    @GetMapping(value = "/")
    public ModelAndView listCategory(){
        ModelAndView modelAndView = new ModelAndView("Category/list");
        List<Category> categoryList = categoryService.getAllCategory();
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView categoryAddForm(){
        ModelAndView modelAndView = new ModelAndView("Category/add");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView categoryAdd(@ModelAttribute Category category){
        ModelAndView modelAndView = new ModelAndView("Category/add");
        try {
            Category newCategory = categoryService.add(category);
            if(newCategory!=null)
                modelAndView.addObject("message","Add successfully");
            modelAndView.addObject("category",newCategory);
            return modelAndView;
        }catch (Exception e){
            modelAndView.addObject("message","Don't add duplicated category name");
            return  modelAndView;

        }

    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView categoryEditForm(@PathVariable("id") Long categoryId){
        ModelAndView modelAndView = new ModelAndView("Category/edit");
        Category category = categoryService.findCategoryById(categoryId);
        modelAndView.addObject("category",category);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView categoryEdit(@ModelAttribute("category") Category category){
        ModelAndView modelAndView = new ModelAndView("Category/edit");
        Category updatedCategory = categoryService.update(category);
        if(updatedCategory!=null){
            modelAndView.addObject("message","Updated successfully");
        }
        modelAndView.addObject("category",updatedCategory);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView categoryDeleteForm(@PathVariable("id") Long categoryId){
        ModelAndView modelAndView = new ModelAndView("Category/delete");
        Category category = categoryService.findCategoryById(categoryId);
        modelAndView.addObject("category",category);
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public String categoryDelete(@ModelAttribute("category") Category category){
        categoryService.remove(category);
        return "redirect:/";
    }

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam("search") String search){
        ModelAndView modelAndView = new ModelAndView("Category/list");
        List<Category> category = categoryService.search(search);
        modelAndView.addObject("category",category);
        return modelAndView;
    }

}
