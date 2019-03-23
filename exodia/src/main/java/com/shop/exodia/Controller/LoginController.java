/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.exodia.Controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author MSI
 */

@RestController
@EnableScheduling
@RequestMapping("/login")
public class LoginController {
    
    @RequestMapping(value = "/userLogin.ajax")
    public String userLogin() {
        return "/index.html";
    }
}
