package com.codegym.Entity;


import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book extends BaseModel{
    @Column(name = "code",nullable = false,unique = true)
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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Categories categories;

    public Book() {
    }

    public Book(String code, String name, String detail, String language, String image, Double price,
                int quantity, boolean status, Categories categories) {
        this.code = code;
        this.name = name;
        this.detail = detail;
        this.language = language;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.categories = categories;
    }

    public Book(String createdDate, String createdBy, String updatedDate, String updatedBy, String code, String name, String detail, String language, String image, Double price, int quantity, boolean status, Categories categories) {
        super(createdDate, createdBy, updatedDate, updatedBy);
        this.code = code;
        this.name = name;
        this.detail = detail;
        this.language = language;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return String.format("Book[super.getId() ='%d',code='%s', name='%s', detail='%s', language='%s', image='%s', price='%f'," +
                " quantity='%d',status='%b']", super.getId(),code, name,detail,language,image,price,quantity,status);
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
