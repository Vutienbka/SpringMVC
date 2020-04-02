package com.codegym.Controller;

import com.codegym.Model.Customer;
import com.codegym.Validation.CustomerValidation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class customerController {

        @GetMapping("/customer")
        public ModelAndView showForm() {
            ModelAndView modelAndView = new ModelAndView("createCustomer");
            modelAndView.addObject("customer", new Customer());
            return modelAndView;
        }

        @PostMapping("/validateCustomer")
        public ModelAndView checkValidation(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
            new CustomerValidation().validate(customer,bindingResult);
            if (bindingResult.hasFieldErrors()) {
                ModelAndView modelAndView = new ModelAndView("createCustomer");
                return modelAndView;
            }

            ModelAndView modelAndView = new ModelAndView("listCustomer");
            return modelAndView;
        }

    }
