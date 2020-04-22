package com.codegym.Service.BookService;

import com.codegym.Entity.Book;
import com.codegym.Entity.Categories;
import com.codegym.Repository.BookRepository.IBookRepository;
import com.codegym.Repository.CategoriesRepository.ICategoriesRepository;
import com.codegym.Service.CategoriesService.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class BookService implements IBookService{


    @Autowired
    IBookRepository bookRepository;
    @Autowired
    ICategoriesService categoriesService;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }


}
