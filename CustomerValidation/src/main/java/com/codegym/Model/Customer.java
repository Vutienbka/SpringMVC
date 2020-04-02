package com.codegym.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerPhoneNumber;
    private int customerAge;

    public Customer() {
    }

    public Customer(String customerName, String customerEmail, String customerAddress, int customerAge, String customerPhoneNumber) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerAge = customerAge;
        this.customerPhoneNumber = customerPhoneNumber;
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

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int age) {
        this.customerAge = age;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
