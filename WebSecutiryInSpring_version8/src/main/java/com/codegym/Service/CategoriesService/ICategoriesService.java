package com.codegym.Service.CategoriesService;

import com.codegym.Entity.Book;
import com.codegym.Entity.Categories;

import java.util.List;

public interface ICategoriesService {
    List<Categories> findAll();
    Categories findById(Long categoryId);
    Categories save(Categories category);
//    Categories addCategory(Categories category, Book book);
    Categories findCategoriesByCategoryCode(String code);
    Categories findCategoriesByCategoryName(String name);
    void remove(Long categoryId);
}
