package com.codegym.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Role")
public class Role extends BaseModel{

    @Column(name = "roleCode")
    private String roleCode;

    @Column(name = "roleName")
    private String roleName;

    @ManyToMany(mappedBy = "roleList")
    private List<User> userList = new ArrayList<>();

    public Role() {
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}