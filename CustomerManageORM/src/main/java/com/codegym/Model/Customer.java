package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table
public class Customer {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerDateOfBirth;

    public Customer() {
    }

    public Customer(int Id, String customerName, String customerEmail, String customerAddress, String customerDateOfBirth) {
        this.Id = Id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }
}
