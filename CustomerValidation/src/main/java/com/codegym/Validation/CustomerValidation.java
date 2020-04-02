package com.codegym.Validation;

import com.codegym.Model.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer= (Customer) target;


        if(customer.getCustomerName().equalsIgnoreCase("")) {
            errors.rejectValue("customerName","Field.empty");
        }else if(customer.getCustomerName().length()<3 || customer.getCustomerName().length()>20){
            errors.rejectValue("customerName","customerName.stringLength");
        }


        if(String.valueOf(customer.getCustomerAge()).equalsIgnoreCase("")){
            errors.rejectValue("customerAge","Field.empty");
        }
       else if(customer.getCustomerAge()<18){
            errors.rejectValue("customerAge","customerAge.greaterThan18");
        }


        if(!customer.getCustomerPhoneNumber().startsWith("0")){
            errors.rejectValue("customerPhoneNumber","phoneNumberStartWithZero.error");
        }
        else if(customer.getCustomerPhoneNumber().length()>10 || customer.getCustomerPhoneNumber().length()<10){
            errors.rejectValue("customerPhoneNumber","phoneNumberLength.error");
        }
        else if(!customer.getCustomerPhoneNumber().matches("(^$|[0-9]*$)")){
            errors.rejectValue("customerPhoneNumber","phoneNumberMatch.error");
        }

        if(customer.getCustomerEmail().equalsIgnoreCase("")){
            errors.rejectValue("customerEmail","Field.empty");
        }else if(!customer.getCustomerEmail().matches("(^[a-zA-Z0-9]+[a-zA-Z0-9]*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+))")){
            errors.rejectValue("customerEmail","Email.match");
        }
    }
}
