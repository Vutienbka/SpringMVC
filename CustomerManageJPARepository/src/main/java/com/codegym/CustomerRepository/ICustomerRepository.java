package com.codegym.CustomerRepository;

import com.codegym.Model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomer();
    void addCustomer(Customer customer);
    Customer findById(Long customerId);
    void save(Customer customer);
    void remove(Customer customer);
    List<Customer> searchCustomerByName(String queryString);
}
