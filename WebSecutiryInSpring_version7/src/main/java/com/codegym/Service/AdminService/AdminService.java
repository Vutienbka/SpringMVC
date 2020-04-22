package com.codegym.Service.AdminService;

import com.codegym.DTO.Admin.AdminRegistration;
import com.codegym.DTO.User.UserRegistration;
import com.codegym.Entity.Role;
import com.codegym.Entity.User;
import com.codegym.Repository.AdminRepository.IAdminRepository;
import com.codegym.Repository.UserRepository.IUserRepository;
import com.codegym.Service.RoleService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class AdminService implements IAdminService{
    @Autowired
    IAdminRepository adminRepository;
    @Autowired
    IRoleService roleService;

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public User findOneByUsernameAndStatus(String username, int status) {
        return adminRepository.findOneByUsernameAndStatus(username,status);
    }

    @Override
    public User findOneByPassword(String password) {
        return adminRepository.findOneByPassword(password);
    }

    @Override
    public User save(User user) {
        return adminRepository.save(user);
    }

    public User addRegistrationAdmin(AdminRegistration adminRegistration){
        User user = new User();
        user.setFullName(adminRegistration.getFullName());
        user.setUsername(adminRegistration.getUsername());
        user.setPassword(adminRegistration.getPassword());
        Role role;
        role = roleService.findByRoleCode("ROLE_ADMIN");
        if(role==null){
            role= new Role("ROLE_ADMIN");
            roleService.addRole(role);
        }
        user.setRoleList(Arrays.asList(role));
//        user.setRoleList(Arrays.asList(new Role("ROLE_USER","user")));
//        user.setStatus(registration.getStatus());
        user.setStatus(1);
        return adminRepository.save(user);
    }

    @Override
    public List<User> findUserListByRole(int roleId) {
        StoredProcedureQuery getUserListQuery = entityManager.createNamedStoredProcedureQuery("getUserListByRole");
        getUserListQuery.setParameter("roleId",roleId);
        getUserListQuery.execute();
        List<User> userList = getUserListQuery.getResultList();
        return  userList;
    }
}
