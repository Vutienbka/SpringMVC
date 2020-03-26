package com.codegym.CustomerController;

import com.codegym.CustomerService.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codegym.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;

@EnableWebMvc
@Controller
public class CustomerController {

    private CustomerService customerService;

    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customer/list", method = RequestMethod.GET)
    public String listCustomer(RedirectAttributes redirect, Model model){
        ArrayList<Customer> customerList = customerService.getAllCustomer();
        if(model.asMap().get("message")!=null){
            redirect.addFlashAttribute("message",model.asMap().get("message").toString());
        }
        model.addAttribute("customerList",customerList);
        return "HomePage";
    }

    @RequestMapping(value = "/customer/{id}/edit")
    public String gotoEditCustomerForm(@PathVariable(value = "id") int customerId, Model model){
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer",customer);
        return "editForm";
    }

    @RequestMapping(value = "/customer/save")
    public String saveCustomer(@ModelAttribute Customer customer,RedirectAttributes redirect){
        boolean check = customerService.saveCustomer(customer);
        if(check) {
            String message = "Edit Successful";
            redirect.addFlashAttribute("message",message);
        }else {
            String message = "Edit Not Successful";
            redirect.addFlashAttribute("message",message);
        }
        return "redirect:/customer/list";
    }

    @RequestMapping(value = "/customer/{Id}/delete")
    public String deleteCustomer(@PathVariable("Id") int customerId, RedirectAttributes redirect){
        boolean check = customerService.deleteCustomer(customerId);
        if(check){
            String message = "Delete Successful";
            redirect.addFlashAttribute("message",message);
        }else {
            String message = "Delete Not Successful";
            redirect.addFlashAttribute("message",message);
        }
        return "redirect:/customer/list";
    }

    @RequestMapping(value = "/customer/addForm")
    public String gotoAddCustomerForm(){
        return "addForm";
    }

    @RequestMapping(value = "/customer/add")
    public String addCustomer(@ModelAttribute Customer newCustomer, RedirectAttributes redirect){
        boolean check = customerService.addCustomer(newCustomer);
        if(check){
            String message = "Add Successful";
            redirect.addFlashAttribute("message",message);
        }else {
            String message = "Add Not Successful";
            redirect.addFlashAttribute("message",message);
        }
        return "redirect:/customer/list";
    }

    @RequestMapping(value="/customer/{id}/view")
    public String viewDetailCustomer(@PathVariable("id") int customerId,Model model){
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer",customer);
        return "customerDetail";
    }

    @RequestMapping(value="/customer/search")

    public String searchList(@RequestParam("search") String querySearch, Model model){
        ArrayList<Customer> customerList;
        customerList = customerService.customerSearch(querySearch);
        model.addAttribute("customerList", customerList);
        return "HomePage";
    }
}
