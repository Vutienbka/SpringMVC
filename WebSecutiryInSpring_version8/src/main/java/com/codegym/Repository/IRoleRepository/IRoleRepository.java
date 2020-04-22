package com.codegym.Repository.IRoleRepository;

import com.codegym.Entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoleRepository extends PagingAndSortingRepository<Role,Long> {
    Role findByRoleCode(String roleCode);
    Role save(Role role);
}
