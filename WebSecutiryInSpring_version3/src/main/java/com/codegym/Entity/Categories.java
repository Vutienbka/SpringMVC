package com.codegym.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Categories extends BaseModel{

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    @JoinTable(name = "Category_Book",joinColumns = @JoinColumn(name = "categoryId"),inverseJoinColumns = @JoinColumn(name = "bookId"))
    private List<Book> bookList = new ArrayList<>();

    public Categories(){}

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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
