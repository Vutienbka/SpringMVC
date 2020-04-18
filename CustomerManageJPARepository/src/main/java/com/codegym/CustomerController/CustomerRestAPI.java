package com.codegym.CustomerController;

import com.codegym.CustomerService.ICustomerService;
import com.codegym.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class CustomerRestAPI {
    @Autowired
    ICustomerService customerService;

    @RequestMapping(value = "API/customers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listCustomer(){
        List<Customer> customerList  = customerService.getAllCustomer();
        if(customerList==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @PostMapping(value = "API/customer/create")
    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "API/getCustomer/{id}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable("id") Long customerId){
        Customer retrievedCustomer = customerService.findById(customerId);
        if(retrievedCustomer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(retrievedCustomer,HttpStatus.FOUND);
    }
    @DeleteMapping(value = "API/deleteCustomer/{id}")
    public ResponseEntity<Void>deleteCustomer(@PathVariable("id") Long customerId){
        Customer deletedCustomer = customerService.findById(customerId);
        customerService.remove(deletedCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "API/editCustomer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> editOneCustomer(@PathVariable("id")Long customerId, @RequestBody Customer customer){
        Customer editCustomer = customerService.findById(customerId);
        //customer la mot doi tuong duoc trong postMan

        if(editCustomer!=null) {
            editCustomer.setCustomerName(customer.getCustomerName());
            editCustomer.setCustomerEmail(customer.getCustomerEmail());
            editCustomer.setCustomerAddress(customer.getCustomerAddress());
            editCustomer.setId(customer.getId());

            customerService.save(editCustomer);
            return new ResponseEntity<>(editCustomer, HttpStatus.OK);
        }else return new ResponseEntity<>((HttpStatus.NO_CONTENT));
    }
    //Tao search theo ten bang @RequestParam hoac @Pathvariable
    @GetMapping(value = "API/customers/searchedByName")
    public ResponseEntity<List<Customer>> getCustomersSearchedByName(@RequestBody Customer customer){
        List<Customer> customerList = customerService.searchCustomerByName(customer.getCustomerName());
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping(value = "API/customers/searchedByName/{customerName}")
    public ResponseEntity<List<Customer>> getCustomerListSearchedByName(@PathVariable("customerName") String customerName){
        List<Customer> customerList = customerService.searchCustomerByName(customerName);
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }
}
