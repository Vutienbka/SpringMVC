package com.codegym.Service.UserService;

import com.codegym.DTO.User.UserRegistration;
import com.codegym.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService{
    User findOneByUsernameAndStatus(String username, int status);
    User findUserById(Long userId);
    User save(User user);
    User addRegistrationUser(UserRegistration registration);

}
