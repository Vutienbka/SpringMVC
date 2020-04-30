package com.codegym.Service.ProductService;

import com.codegym.Entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    Product addProduct(Product product);
}
