package com.codegym.CustomerController;

import com.codegym.CustomerService.ICustomerService;
import com.codegym.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("myCounter")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping(value = "/customers")
    public ModelAndView listCustomers(){
        List<Customer> customers;
        customers = customerService.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("Customer/listCustomer");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

//    @ModelAttribute("myCounter")
//    public MyPageViewCounter setUpCounter(){
//        return new MyPageViewCounter();
//    }
//
    @GetMapping(value = "/create/customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("Customer/createCustomer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create/customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.addCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("Customer/createCustomer");
       // modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {

        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("Customer/editCustomer");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("Customer/error404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("Customer/editCustomer");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("Customer/deleteCustomer");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("Customer/error404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer);
        return "redirect:customers";
    }

    @GetMapping(value = "/customer/searchedByName")

    public ModelAndView getCustomerSearchedByName(@RequestParam("searchQuery") String searchQuery){
        List<Customer> customerList = customerService.searchCustomerByName(searchQuery);
        ModelAndView modelAndView = new ModelAndView("Customer/listCustomer");
        modelAndView.addObject("customers",customerList);
        return modelAndView;
    }

}
