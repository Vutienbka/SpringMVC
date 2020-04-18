package com.codegym.Repository.BookRepository;

import com.codegym.Entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBookRepository extends CrudRepository<Book,Long> {
}
