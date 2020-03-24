package com.codegym.CustomerRepository;

import com.codegym.Model.Customer;
import java.util.ArrayList;

public interface ICustomerRepository {

    ArrayList<Customer> getAllCustomer();

    Customer findById(int customerId);

    boolean saveCustomer(Customer customer);

    boolean deleteCustomer(int customerId);

    boolean addCustomer(Customer customer);

    ArrayList<Customer> customerSearch(String query);
}
