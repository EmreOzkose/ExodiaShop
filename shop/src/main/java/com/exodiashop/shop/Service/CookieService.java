package com.exodiashop.shop.Service;

import com.exodiashop.shop.DAO.CommentDAO;
import com.exodiashop.shop.Model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap; // import the HashMap class

@Service
public class CookieService {

    public CookieService(){

    }

    public HashMap<String, String> getAllCookies(HttpServletRequest request, HttpServletResponse response){
        HashMap<String, String> cookie_list = new HashMap<String, String>();

        Cookie cookie = null;
        Cookie[] cookies = null;

        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();

        if( cookies != null ) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                cookie_list.put(cookie.getName(), cookie.getValue());
            }
        }

        return cookie_list;
    }

    public String getCookie(HttpServletRequest request, HttpServletResponse response, String cookieName){
        HashMap<String, String> cookie_list = getAllCookies(request, response);

        return cookie_list.get(cookieName);
    }

}
