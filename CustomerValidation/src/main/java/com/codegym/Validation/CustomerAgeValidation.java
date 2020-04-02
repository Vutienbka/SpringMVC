//package com.codegym.Validation;
//
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//public class CustomerAgeValidation implements Validator {
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return int.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        int customerAge = (int)target;
//        ValidationUtils.rejectIfEmpty(errors,"customerAge","customerAge.greaterThan18");
//    }
//}
