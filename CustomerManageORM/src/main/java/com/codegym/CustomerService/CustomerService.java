package com.codegym.CustomerService;

import com.codegym.CustomerRepository.CustomerRepositoryHibernate;
import com.codegym.Model.Customer;

import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    CustomerRepositoryHibernate customerRepositoryHibernate;

    public CustomerService(CustomerRepositoryHibernate customerRepositoryHibernate){
        this.customerRepositoryHibernate = customerRepositoryHibernate;
    }

    @Override
    public ArrayList<Customer> getAllCustomer() {
        return customerRepositoryHibernate.getAllCustomer();
    }

    @Override
    public Customer findById(int customerId) {
        return customerRepositoryHibernate.findById(customerId);
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        return customerRepositoryHibernate.saveCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        return customerRepositoryHibernate.deleteCustomer(customerId);
    }

    @Override
    public boolean addCustomer(Customer newCustomer) {
        return customerRepositoryHibernate.addCustomer(newCustomer);
    }
    @Override
    public ArrayList<Customer> customerSearch(String querySearch) {
        return customerRepositoryHibernate.customerSearch(querySearch);
    }
}
