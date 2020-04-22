package com.codegym.DTO.MyCart;

import com.codegym.Entity.Book;
import com.codegym.Entity.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


public class MyCart {
    private Long Id;
    private User user;
    private List<Item> itemList;
    private Boolean status;

    public MyCart(){
        this.status= false;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
