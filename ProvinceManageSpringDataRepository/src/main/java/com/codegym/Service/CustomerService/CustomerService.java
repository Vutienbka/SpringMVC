package com.codegym.Service.CustomerService;

import com.codegym.Model.Customer;
import com.codegym.Model.Province;
import com.codegym.Repository.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long customerId) {
        return customerRepository.findOne(customerId);
    }

    @Override
    public List<Customer> findAllByProvince(Province province){
        return (List<Customer>) customerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContaining(Optional<String> name, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(name,pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long customerId) {
        customerRepository.delete(customerId);
    }
}
