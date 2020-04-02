package com.codegym.Controller.CustomerController;

import com.codegym.Model.Customer;
import com.codegym.Model.Province;
import com.codegym.Service.CustomerService.CustomerService;
import com.codegym.Service.CustomerService.ICustomerService;
import com.codegym.Service.ProvinceService.IProvinceService;
import com.codegym.Service.ProvinceService.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    IProvinceService provinceService;

    @ModelAttribute("provinces")
    public List<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping(value = "/customers")
    public ModelAndView listCustomers(){
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("Customer/listCustomer");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping(value = "/create/customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("Customer/createCustomer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create/customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("Customer/createCustomer");
       // modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("Customer/editCustomer");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
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
        Optional<Customer> customer = customerService.findById(id);
        Customer foundCustomer = customer.get();
        if(foundCustomer != null) {
            ModelAndView modelAndView = new ModelAndView("Customer/deleteCustomer");
            modelAndView.addObject("customer", foundCustomer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("Customer/error404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:customers";
    }

}
