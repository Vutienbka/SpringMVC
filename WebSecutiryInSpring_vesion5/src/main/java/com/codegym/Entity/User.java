package com.codegym.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")

@NamedStoredProcedureQuery(
        name = "getUserListByRole",
        procedureName = "getUserList_By_Role",
        resultClasses = {User.class},
        parameters = {
                @StoredProcedureParameter(name = "roleId",mode = ParameterMode.IN,type = Integer.class)
        }
)
public class User extends BaseModel{

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "status")
    private int status;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE )
    @JoinTable(name = "User_Role",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns =@JoinColumn(name = "roleId"))
    private List<Role> roleList = new ArrayList<>();

    public User() {
    }

//    public User(String username, String password, String fullName, int status) {
//        this.username = username;
//        this.password = password;
//        this.fullName = fullName;
//        this.status = status;
//    }

    public User(String fullName,String username, String password, int status, List<Role> roleList) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.status = status;
        this.roleList = roleList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
