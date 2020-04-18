package com.codegym.CustomerService;


import com.codegym.CustomerRepository.ICustomerRepository;
import com.codegym.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CustomerService implements ICustomerService {

@Autowired
ICustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public void addCustomer(Customer customer) {

        customerRepository.addCustomer(customer);
    }

    @Override
    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        customerRepository.remove(customer);
    }

    @Override
    public List<Customer> searchCustomerByName(String customerName) {
        return customerRepository.searchCustomerByName(customerName);
    }

}
