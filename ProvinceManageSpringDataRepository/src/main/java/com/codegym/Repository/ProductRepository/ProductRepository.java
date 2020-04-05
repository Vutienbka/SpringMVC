package com.codegym.Repository.ProductRepository;

import com.codegym.Model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
}
