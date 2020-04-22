package com.codegym.Service.AdminService;

import com.codegym.DTO.Admin.AdminRegistration;
import com.codegym.DTO.User.UserRegistration;
import com.codegym.Entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IAdminService {
    User findOneByUsernameAndStatus(String username, int status);
    User findOneByPassword(String password);
    User save(User user);
    User addRegistrationAdmin(AdminRegistration adminRegistration);
    List<User> findUserListByRole(int RoleId);
}
