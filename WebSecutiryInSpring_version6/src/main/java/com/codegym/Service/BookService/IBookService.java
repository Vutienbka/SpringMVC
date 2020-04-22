package com.codegym.Service.BookService;

import com.codegym.Entity.Book;
import com.codegym.Entity.Categories;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book addBook(Book book);
}
