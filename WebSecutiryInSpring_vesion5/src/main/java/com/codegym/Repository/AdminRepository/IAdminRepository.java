package com.codegym.Repository.AdminRepository;

import com.codegym.Entity.Book;
import com.codegym.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;

public interface IAdminRepository extends PagingAndSortingRepository<User,Long> {
    User findOneByUsernameAndStatus(String username, int status);
    User findOneByPassword(String password);

}
