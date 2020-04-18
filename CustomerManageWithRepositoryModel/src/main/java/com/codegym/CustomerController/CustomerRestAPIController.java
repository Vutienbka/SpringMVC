package com.codegym.CustomerController;

import com.codegym.Model.Customer;
import com.codegym.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestAPIController {
    @Autowired
    ICustomerService customerService;
    @RequestMapping(value = "API/customers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listCustomer(){
        List<Customer> customerList  = customerService.getAllCustomer();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

}
