package com.exodiashop.shop.Service;

import com.exodiashop.shop.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    List<User> userList = new ArrayList<User>( Arrays.asList(
                    new User("Yunusemre", "Özköse", "yunus@hotmail.com", "yunusemre123", 21,0,1),
                    new User("Büşra", "Ekşi", "busra@hotmail.com", "busra123", 21,0,1),
                    new User("Ahmet", "Özköse", "ahmet@hotmail.com", "ahmetdayi", 16,1,0)
            )
    );

    public List<User> getUserList(){
        return userList;
    }


    public User getUserByUserName(String username){
        return getUserList().stream().filter(t -> t.getUsername().equals(username)).findFirst().get();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void updateUser(User user, String username){
        for (int i=0; i<userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                userList.set(i, user);
                break;
            }
        }
    }

    public User validateUser(String userName, String password) {

        User u = new User("Derya", "Durmaz", "derya@hotmail.com", "derya123", 22, 1,1);
        return u;
    }

}
