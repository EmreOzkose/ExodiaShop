package com.exodiashop.shop.Service;

import com.exodiashop.shop.DAO.CommentDAO;
import com.exodiashop.shop.Model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    CommentDAO commentDAO;

    public CommentService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Module.xml");
        this.commentDAO = (CommentDAO) context.getBean("commentDAO");
    }

    public List<Comment> getCommentsByProductID(int productID){
        return commentDAO.getCommentsByProductID(productID);
    }

}
