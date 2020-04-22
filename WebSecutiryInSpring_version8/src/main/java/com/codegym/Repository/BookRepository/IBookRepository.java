package com.codegym.Repository.BookRepository;

import com.codegym.Entity.Book;
import com.codegym.Entity.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public interface IBookRepository extends PagingAndSortingRepository<Book,Long> {
    List<Book> findAllByNameContaining(String query);
    Page<Book> findAllByNameStartsWith(String name, Pageable pageable);
    Page<Book> findAllByCategories(Categories category, Pageable pageable);
}
