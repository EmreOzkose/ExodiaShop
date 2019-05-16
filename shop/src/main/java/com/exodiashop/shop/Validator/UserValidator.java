package com.exodiashop.shop.Validator;


import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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
        System.out.println(user.getUsername());
        System.out.println(user.getGender());
        System.out.println(user.getEmail());

        if (userService.check_username(user.getUsername()) != false) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        if(user.getUsername().charAt(0) == ' '){
            errors.rejectValue("username", "NotEmpty.space");
        }
        if(user.getPassword().contains(" ")){
            errors.rejectValue("password", "NotEmpty.space.password");
        }
        if (!(user.getGender().toLowerCase().compareTo("male")==0 || user.getGender().toLowerCase().compareTo("female") ==0)) {
            errors.rejectValue("gender", "MaleOrFemale");
        }
        if (userService.check_email(user.getEmail()) != false) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
        if(user.getDateofbirth() == null){
            errors.rejectValue("dateofbirth", "typeMismatch.postForm.date");
        }

    }
}
