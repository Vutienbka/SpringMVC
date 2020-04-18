package com.codegym.Repository.AdminRepository;

import com.codegym.Entity.Book;
import com.codegym.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IAdminRepository extends CrudRepository<Book,Long>{
    User save(User user);
}
