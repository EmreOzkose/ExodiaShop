package com.exodia.validator;

import com.exodia.model.Customer;
import com.exodia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private CustomerService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (customer.getUsername().length() < 6 || customer.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        /*
        if (userService.findByUsername(customer.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }*/

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (customer.getPassword().length() < 8 || customer.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        /*
        if (!customer.getPasswordConfirm().equals(customer.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }*/
    }
}
