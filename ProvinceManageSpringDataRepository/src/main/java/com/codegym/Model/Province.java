package com.codegym.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String provinceName;

    @OneToMany(mappedBy = "province")
    private List<Customer> customerList;

    public Province() {
    }

    public Province(String provinceName){
        this.provinceName = provinceName;
    }

    public Province(Long Id, String provinceName){
        this.Id = Id;
        this.provinceName = provinceName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
