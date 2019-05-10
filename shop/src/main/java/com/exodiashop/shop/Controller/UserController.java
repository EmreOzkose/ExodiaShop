package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.getUserList();
    }

    @RequestMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.getUserByUserName(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/{username}")
    public void updateUser(@RequestBody User user, @PathVariable String username){
        userService.updateUser(user, username);
    }


    /*import java.io.File;
    File dir = new File("./src/main/webapp/WEB-INF/pages/");
    File[] filesList = dir.listFiles();
        for (File file : filesList) {
        if (file.isFile()) {
            System.out.println(file.getName());
        }
    }*/

}
