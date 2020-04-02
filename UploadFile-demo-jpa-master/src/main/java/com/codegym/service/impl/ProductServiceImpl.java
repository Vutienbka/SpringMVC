package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.impl.ProductRepositoryImpl;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void add(Product product) {
        // xu ly nghiep vu (vd:upload file, validate..)
        productRepository.add(product);
        // xu ly nghiep vu
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
