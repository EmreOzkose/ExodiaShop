package com.exodia.validator;

import com.exodia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.exodia.service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (userService.check_username(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        } 
        if(user.getUsername().charAt(0) == ' '){
            errors.rejectValue("username", "NotEmpty.space");
        }
        if(user.getPassword().contains(" ")){
            errors.rejectValue("password", "NotEmpty.space.password");
        }
    }
}
