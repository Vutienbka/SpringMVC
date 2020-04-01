package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;

    private String customerName;
    private String customerEmail;
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name="province_Id")
    private Province province;

    public Customer() {
    }

    public Customer( String customerName, String customerEmail, String customerAddress, Province province) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.province = province;
    }
    @Override
    public String toString() {
        return String.format("Customer[Id=%d, customerName='%s', customerEmail='%s', customerAddress='%s']", Id, customerName, customerEmail,customerAddress);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
