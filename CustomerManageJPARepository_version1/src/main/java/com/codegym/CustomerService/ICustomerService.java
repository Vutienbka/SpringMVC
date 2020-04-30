package com.codegym.CustomerService;

import com.codegym.Model.Customer;

import java.util.List;

public interface ICustomerService{
    List<Customer> getAllCustomer();
    void addCustomer(Customer customer);
    Customer findById(Long customerId);
    void save(Customer customer);
    void remove(Customer customer);
    List<Customer> searchCustomerByName(String customerName);
}
