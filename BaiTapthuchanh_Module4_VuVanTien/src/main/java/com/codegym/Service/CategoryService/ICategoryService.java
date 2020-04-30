package com.codegym.Service.CategoryService;

import com.codegym.Entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();
    Category findCategoryById(Long id);
    Category add(Category category);
    Category update(Category category);
    void remove(Category category);
    List<Category> search(String query);
}
