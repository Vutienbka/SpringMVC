package com.codegym.Repository.CategoriesRepository;

import com.codegym.Entity.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoriesRepository extends PagingAndSortingRepository<Categories,Long> {
    Categories findCategoriesByCategoryCode(String code);
}
