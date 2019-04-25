package com.exodia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.exodia.model.Login;
import com.exodia.model.User;

public class UserDaoImpl implements UserDao {
    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void register(User user) {

        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, new Object[] {user.getId(), user.getUsername(), user.getPassword(), user.getName(),user.getSurname(),user.getDateofbirth(),user.getGender(), user.getEmail(), user.getAddress(), user.getPhonenumber() , "customer"});
    }

    @Override
    public User validateUser(Login login) {

      String sql = "select * from user where username='" + login.getUsername() + "' and password='" + login.getPassword()
          + "'";

      List<User> users = jdbcTemplate.query(sql, new UserMapper());

      return users.size() > 0 ? users.get(0) : null;
    }
  
    @Override
      public Boolean check_username(String Username) {
          String sql = "select * from user where username='" + Username +  "'";

          List<User> users = jdbcTemplate.query(sql, new UserMapper());
          /*size 0 den büyükse , true döndürür yoksa null*/
          return users.size() > 0 ? true : null;
      }
    @Override
      public Boolean check_email(String email) {
          String sql = "select * from user where email='" + email +  "'";

          List<User> users = jdbcTemplate.query(sql, new UserMapper());
          /*size 0 den büyükse , true döndürür yoksa null*/
          return users.size() > 0 ? true : null;
      }
    @Override
      public Boolean check_pnumber(String pnumber) {
          String sql = "select * from user where phonenumber='" + pnumber +  "'";

          List<User> users = jdbcTemplate.query(sql, new UserMapper());
          /*size 0 den büyükse , true döndürür yoksa null*/
          return users.size() > 0 ? true : null;
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

    return user;
  }
}