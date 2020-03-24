package com.codegym.Service;

import com.codegym.CustomerRepository.CustomerRepository;
import com.codegym.Model.Customer;
import java.util.ArrayList;

public class CustomerService implements ICustomerService{

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public ArrayList<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    public Customer findById(int customerId) {
        return customerRepository.findById(customerId);
    }

    public boolean saveCustomer(Customer customer){
        return customerRepository.saveCustomer(customer);
    }

    public boolean deleteCustomer(int customerId){
        return customerRepository.deleteCustomer(customerId);
    }

    public boolean addCustomer(Customer customer){
        return customerRepository.addCustomer(customer);
    }

    public ArrayList<Customer> customerSearch(String query){
        if((query.equalsIgnoreCase("")) || (query.isEmpty())){
            return customerRepository.getAllCustomer();
        }else {
            return customerRepository.customerSearchWithText(query);
        }


    }
}
