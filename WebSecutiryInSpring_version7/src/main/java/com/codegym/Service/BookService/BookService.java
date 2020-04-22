package com.codegym.Service.BookService;

import com.codegym.Entity.Book;
import com.codegym.Repository.BookRepository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

//@Transactional
public class BookService implements IBookService{


    @Autowired
    IBookRepository bookRepository;

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

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findOne(bookId);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void remove(Long bookId) {
        bookRepository.delete(bookId);
    }

    @Override
    public List<Book> getSearchResult(String query) {
        return bookRepository.findAllByNameContaining(query);
    }

    @Override
    public Page<Book> getAllBooks(String startWithText, int size, int page) {
            Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "name");

            if (startWithText.isEmpty()) {
                return this.bookRepository.findAll(pageable);
            } else {
                return this.bookRepository.findAllByNameStartsWith(startWithText, pageable);
            }
    }

}
