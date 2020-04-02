package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String name;
    private Double price;
    private Double quantity;
    private String description;

    public Product() {
    }

    public Product(String image, String name, Double price, Double quantity, String description) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    /*public Product(Long id, String image, String name, Double price, Double quantity, String description) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
