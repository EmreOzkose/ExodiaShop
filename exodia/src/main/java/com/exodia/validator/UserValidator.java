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
        
        if(user.getUsername().contains(" ")){
            errors.rejectValue("username", "NotEmpty.space");
        }

        
        /*if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }*/
        
        if (!user.getPasswordconfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        if(user.getPassword().contains(" ")){
            errors.rejectValue("password", "NotEmpty.space");
        }
        
        if (user.getGender().toLowerCase().compareTo("erkek") != 0 && user.getGender().toLowerCase().compareTo("kadin") !=0 ) {
            errors.rejectValue("gender", "maleorfemale");
        }
        
        /*String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (user.getEmail().matches(regex) == false) {
            errors.rejectValue("email", "email.validate");
        }*/
        if (userService.check_email(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
        
        if (userService.check_pnumber(user.getPhonenumber()) != null && user.getPhonenumber().length()!=0) {
            errors.rejectValue("phonenumber", "Duplicate.userForm.phonenumber");
        }
        
        if(user.getDateofbirth() == null){
            errors.rejectValue("dateofbirth", "typeMismatch.postForm.date");
        }
        /*
        if (user.getPhonenumber().length()!=0 && user.getPhonenumber().length()!=11) {
            errors.rejectValue("Phonenumber", "Size.userForm.phonenumber");
        } */   
    }
}
