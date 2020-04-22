package com.codegym.Repository.BookRepository;

import com.codegym.Entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public interface IBookRepository extends PagingAndSortingRepository<Book,Long> {
}
