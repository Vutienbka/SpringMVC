package com.codegym.Service.BookService;

import com.codegym.Entity.Book;
import com.codegym.Entity.Categories;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book addBook(Book book);
    Book findById(Long bookId);
    Book update(Book book);
    void remove(Long bookId);
    List<Book> getSearchResult(String query);
    Page<Book> getAllBooks(String startWithText, int size, int page);
}
