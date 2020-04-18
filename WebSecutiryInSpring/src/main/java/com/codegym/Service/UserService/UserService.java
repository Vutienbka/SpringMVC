package com.codegym.Service.UserService;

import com.codegym.DTO.User.UserRegistration;
import com.codegym.Entity.Role;
import com.codegym.Entity.User;
import com.codegym.Repository.UserRepository.IUserRepository;
import com.codegym.Service.RoleService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRoleService roleService;
    @Override
    public User findOneByUsernameAndStatus(String username, int status) {
        return userRepository.findOneByUsernameAndStatus(username,status);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    public User addRegistrationUser(UserRegistration registration){
        User user = new User();
        user.setFullName(registration.getFullName());
        user.setUsername(registration.getUsername());
        user.setPassword(registration.getPassword());
        Role role;
        role = roleService.findByRoleCode("ROLE_USER");
        if(role==null){
            role= new Role("ROLE_USER","user");
            roleService.addRole(role);
        }
        user.setRoleList(Arrays.asList(role));
//        user.setRoleList(Arrays.asList(new Role("ROLE_USER","user")));
//        user.setStatus(registration.getStatus());
        user.setStatus(1);
        return userRepository.save(user);

    }
}
