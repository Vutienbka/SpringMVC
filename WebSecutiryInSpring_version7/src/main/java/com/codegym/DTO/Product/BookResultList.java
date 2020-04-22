package com.codegym.DTO.Product;

import com.codegym.Entity.Book;

import java.util.List;

public class BookResultList {
    private List<Book> data;
    private Pagination pagination;

    public List<Book> getData() {
        return data;
    }

    public void setData(List<Book> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
