package com.codegym.Repository.AdminRepository;

import com.codegym.Entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IBookRepository extends CrudRepository<Book,Long>{

}
