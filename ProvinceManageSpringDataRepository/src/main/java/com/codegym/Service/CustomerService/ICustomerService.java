package com.codegym.Service.CustomerService;

import com.codegym.Model.Customer;
import com.codegym.Model.Province;

import java.util.List;
import java.util.Optional;

public interface ICustomerService{
    List<Customer> findAll();
    Optional<Customer> findById(Long customerId);
    List<Customer> findAllByProvince(Optional<Province> province);
    void save(Customer customer);
    void remove(Long customerId);
}
