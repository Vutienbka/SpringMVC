package com.codegym.Service.CustomerService;

import com.codegym.Model.Customer;
import com.codegym.Model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService{
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long customerId);
    List<Customer> findAllByProvince(Province province);
    Page<Customer>findAllByCustomerNameContaining(Optional<String> name, Pageable pageable);
    void save(Customer customer);
    void remove(Long customerId);
}
