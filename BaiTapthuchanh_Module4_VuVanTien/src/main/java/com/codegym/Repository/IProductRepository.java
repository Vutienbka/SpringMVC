package com.codegym.Repository;

import com.codegym.Entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
}
