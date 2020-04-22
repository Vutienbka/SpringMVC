package com.codegym.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Categories extends BaseModel{

    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "categoryCode")
    private String categoryCode;

//    cascade = CascadeType.ALL,orphanRemoval = true
    @OneToMany(mappedBy = "categories")
    private List<Book> bookList = new ArrayList<>();

    public Categories(){}

    public Categories(String categoryName, String categoryCode, List<Book> bookList) {
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.bookList = bookList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
