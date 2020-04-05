package com.codegym.Controller.CustomerController;

import com.codegym.Model.Customer;
import com.codegym.Model.MyPageViewCounter;
import com.codegym.Model.Province;
import com.codegym.Service.CustomerService.ICustomerService;
import com.codegym.Service.ProvinceService.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("myCounter")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    IProvinceService provinceService;

    @Autowired
    HttpSession session;

    @ModelAttribute("provinces")
    public List<Province> provinces(){
        return provinceService.findAll();
    }


    @GetMapping(value = "/customers")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Customer> customers;
        if(search.isPresent()){
            customers = customerService.findAllByCustomerNameContaining(search,pageable);
        }else {
            customers = customerService.findAll(pageable);
            System.out.println(customers.getSize());
        }
        ModelAndView modelAndView = new ModelAndView("Customer/listCustomer");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @ModelAttribute("myCounter")
    public MyPageViewCounter setUpCounter(){
        return new MyPageViewCounter();
    }

    @GetMapping(value = "/create/customer")
    public ModelAndView showCreateForm(@ModelAttribute("myCounter") MyPageViewCounter myCounter){
        myCounter.increment();

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

        Object isSignedIn = session.getAttribute("isSignedIn");
        if(isSignedIn!=null) {
            Customer customer = customerService.findById(id);
            if (customer != null) {
                ModelAndView modelAndView = new ModelAndView("Customer/editCustomer");
                modelAndView.addObject("customer", customer);
                return modelAndView;

            } else {
                ModelAndView modelAndView = new ModelAndView("Customer/error404");
                return modelAndView;
            }
        }else {
            ModelAndView modelAndView = new ModelAndView("SignIn/SignIn");
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
//        Customer foundCustomer = customer.get();
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
        customerService.remove(customer.getId());
        return "redirect:customers";
    }

}
