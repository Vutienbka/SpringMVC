package com.codegym.Service.RoleService;

import com.codegym.DTO.User.UserRegistration;
import com.codegym.Entity.Role;
import com.codegym.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.jws.soap.SOAPBinding;

public interface IRoleService{
    Role findByRoleCode(String roleCode);
    void addUser(UserRegistration registration);
    Role addRole(Role role);

}
