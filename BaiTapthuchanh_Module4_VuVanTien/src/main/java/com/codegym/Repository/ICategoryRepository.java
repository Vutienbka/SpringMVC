package com.codegym.Repository;

import com.codegym.Entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
    List<Category> findCategoryByNameContaining(String query);
}
