package com.codegym.Repository;

import com.codegym.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends CrudRepository<User,Long> {
    User findOneByUsernameAndStatus(String username, int status);
}
