package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import java.util.Date;

public class ProductForm {

    private Long id;
    private MultipartFile image;
    private String name;
    private Double price;
    private Double quantity;
    private String description;


    public ProductForm() {
    }

    public ProductForm(MultipartFile image, String name, Double price, Double quantity, String description) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;

    }

    public ProductForm(Long id, MultipartFile image, String name, Double price, Double quantity, String description) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

