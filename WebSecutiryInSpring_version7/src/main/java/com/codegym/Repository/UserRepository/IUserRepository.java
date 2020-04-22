package com.codegym.Repository.UserRepository;

import com.codegym.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User,Long> {
    User findOneByUsernameAndStatus(String username, int status);
}
