package com.exodiashop.shop.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Types;

import javax.sql.DataSource;

import com.exodiashop.shop.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDAO extends JdbcDaoSupport{

    @Autowired
    DataSource datasource;

    public void register(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[] {user.getId(), user.getUsername(), user.getPassword(), user.getName(),user.getSurname(),user.getDateofbirth(),user.getGender(), user.getEmail(), user.getAddress(), user.getPhonenumber() , "user"});
    }

    public List<User> getAllUsers() {
        String sql = "select * from user";
        List<User> user_list = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(User.class));

        for (User u : user_list)
            System.out.println(u.getUsername());

        return user_list;
    }

    public User getUserByUsername(String username) {
        String sql = "select * from user where username='" + username + "'";

        List<User> user_list = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(User.class));

        return user_list.size() > 0 ? user_list.get(0) : null;
    }

    public void updateUser(String username, String newUsername){
        System.out.println("s: " + username + " new : " + newUsername);

        getJdbcTemplate().update("update user set username = ? where username = ?", newUsername, username);

    }

}

class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        /*galiba jsp den gelen yazılar*/

        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setDateofbirth(rs.getDate("dateofbirth"));
        user.setGender(rs.getString("gender"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setPhonenumber(rs.getString("phonenumber"));
        user.setProfilePhoto(rs.getString("profilePhoto"));

        return user;
    }
}