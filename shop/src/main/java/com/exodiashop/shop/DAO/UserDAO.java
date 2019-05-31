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
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?,?)";

        /*blocks duplicate 0len input*/
        if(user.getPhonenumber().length()==0){
            user.setPhonenumber(null);
        }

        getJdbcTemplate().update(sql, new Object[] {user.getId(), user.getUsername(), user.getPassword(), user.getName(),user.getSurname(),user.getDateofbirth(),user.getGender(), user.getEmail(), user.getAddress(), user.getPhonenumber() , "user",user.getProfilePhoto()});
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

        List<User> user_list = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(User.class));

        return user_list.size() > 0 ? user_list.get(0) : null;
    }

    public void updateUser(String username, String newUsername, String newName, String newSurname, String newEmail, String newPassword){
        System.out.println("s: " + username + " new : " + newUsername);
        getJdbcTemplate().update("update user set username = ?, name = ?, surname = ?, email = ?, password = ? where username = ?", newUsername, newName, newSurname, newEmail, newPassword, username);
    }

    public String getShoppingCartByUsername(String username){
        String sql = "SELECT shoppingCart FROM user WHERE username=?";

        String shoppingCart = (String)getJdbcTemplate().queryForObject(   sql, new Object[] { username }, String.class);

        return shoppingCart;
    }

    public void add2cart(String username, String productID){
        String shoppingCart = getShoppingCartByUsername(username);

        if (shoppingCart.equals("") || shoppingCart == null)
            shoppingCart = productID;
        else
            shoppingCart += "," + productID;

        getJdbcTemplate().update("update user set shoppingCart=? where username = ?", shoppingCart, username);

    }

    public void deleteFromShoppingCart(String username, String productID){
        String shoppingCart = getShoppingCartByUsername(username);

        if (!shoppingCart.contains(",")){
            // shopping cart contain just 1 item

            getJdbcTemplate().update("update user set shoppingCart=? where username = ?", "", username);
        }
        else{
            String [] splitted = shoppingCart.split(",");
            String tmp = "";
            for(int i=0; i<splitted.length;i++) {
                String s = splitted[i];
                if (!s.equals(productID) && tmp.equals(""))
                    tmp += s;
                else if (!s.equals(productID))
                    tmp += ',' + s;
            }

            getJdbcTemplate().update("update user set shoppingCart=? where username = ?", tmp, username);
        }

    }
    /*for login system*/
    public User validateUser(String username, String password) {
        String sql = "select * from user where username='" + username + "' and password='" + password + "'";

        List<User> users = getJdbcTemplate().query(sql, new UserMapper());

        return users.size() > 0 ? users.get(0) : null;
    }

    public boolean check_username(String username) {
        String sql = "select * from user where username='" + username +  "'";

        List<User> users = getJdbcTemplate().query(sql, new UserMapper());
        /*size 0 den büyükse , true döndürür yoksa null*/
        return users.size() > 0 ? true : false;
    }

    public boolean check_email(String email) {
        String sql = "select * from user where email='" + email +  "'";

        List<User> users = getJdbcTemplate().query(sql, new UserMapper());
        /*size 0 den büyükse , true döndürür yoksa null*/
        return users.size() > 0 ? true : false;
    }

    public String deleteUser(String username, String password) {
        String sql ="delete from user where username ='"+username+"' and where password ='"+password+"'";

        int update = getJdbcTemplate().update(sql);
        if (update == 0) {
            return "Failed";
        } else {
            return "SUCCESS";
        }
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