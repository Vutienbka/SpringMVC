package com.codegym.Service.ProductService;

import com.codegym.Model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long productId);
    void save(Product product);
    void remove(Long productId);
}
