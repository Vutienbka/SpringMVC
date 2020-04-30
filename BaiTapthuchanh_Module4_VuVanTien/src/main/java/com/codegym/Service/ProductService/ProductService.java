package com.codegym.Service.ProductService;

import com.codegym.Entity.Product;
import com.codegym.Repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService{
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
