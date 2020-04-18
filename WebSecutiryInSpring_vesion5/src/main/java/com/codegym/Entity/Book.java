package com.codegym.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book extends BaseModel{

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "detail")
    private String detail;

    @Column(name = "language")
    private String language;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private boolean status;


    @ManyToOne
    @JoinTable(name = "Category_Book",joinColumns = @JoinColumn(name = "bookId"),inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Categories categories;

    public Book() {
    }

    public Book(String name, String code, String detail, String image, Double price, int quantity, Categories categories) {
        this.name = name;
        this.code = code;
        this.detail = detail;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
