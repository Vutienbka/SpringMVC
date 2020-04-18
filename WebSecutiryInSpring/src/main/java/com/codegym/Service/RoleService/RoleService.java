package com.codegym.Service.RoleService;

import com.codegym.DTO.User.UserRegistration;
import com.codegym.Entity.Role;
import com.codegym.Entity.User;
import com.codegym.Repository.IRoleRepository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class RoleService implements IRoleService{

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public Role findByRoleCode(String roleCode) {
        return roleRepository.findByRoleCode(roleCode);
    }


    public void addUser(UserRegistration registration) {
//        Role role = roleRepository.findByRoleCode("ROLE_USER");
//        User user = new User(registration.getUsername(),registration.getPassword(),registration.getFullName(),registration.getStatus());
//        role.getUserList().add(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

}
