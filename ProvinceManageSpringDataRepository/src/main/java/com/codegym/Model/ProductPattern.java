package com.codegym.Model;

import org.springframework.web.multipart.MultipartFile;


public class ProductPattern {

    private Long Id;
    private MultipartFile productImage;
    private String productName;
    private Double productPrice;
    private Double productQuantity;
    private String productDescription;


    public ProductPattern() {
    }

    public ProductPattern(MultipartFile productImage, String productName, Double productPrice, Double productQuantity, String productDescription) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;

    }

    public ProductPattern(Long Id, MultipartFile productImage, String productName, Double productPrice, Double productQuantity, String productDescription) {
        this.Id = Id;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}

