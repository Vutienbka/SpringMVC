package com.codegym.Service.CustomerService;

import com.codegym.Model.Customer;
import com.codegym.Model.Province;
import com.codegym.Repository.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public List<Customer> findAllByProvince(Optional<Province> province){
        return (List<Customer>) customerRepository.findAllByProvince(province);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
