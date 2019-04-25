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

<<<<<<< HEAD:exodia/src/main/java/com/exodia/dao/UserDaoImpl.java
  public void register(User user) {

    String sql = "insert into user(username, password, name, surname,dateofbirth, gender, email, address, phonenumber, role) values(?,?,?,?,?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getName(),user.getSurname(),user.getDateofbirth(),user.getGender(), user.getEmail(), user.getAddress(), user.getPhonenumber(), user.getRole()});
  }

  public User validateUser(Login login) {
=======

    @Override
    public void register(Customer customer) {

        String sql = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, new Object[] {3, customer.getUsername(), customer.getPassword(), customer.getName(),customer.getSurname(),customer.getDateofbirth(),customer.getGender(), customer.getEmail(), customer.getAddress(), customer.getPhonenumber()});
    }
>>>>>>> 948653c7047f5286bec97ed5c6f710522deedf2e:exodia/src/main/java/com/exodia/dao/CustomerDaoImpl.java

    @Override
    public Customer validateUser(Login login) {

<<<<<<< HEAD:exodia/src/main/java/com/exodia/dao/UserDaoImpl.java
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
=======
        String sql = "select * from customer where username='" + login.getUsername() + "' and password='" + login.getPassword() + "'";
>>>>>>> 948653c7047f5286bec97ed5c6f710522deedf2e:exodia/src/main/java/com/exodia/dao/CustomerDaoImpl.java

        List<Customer> users = jdbcTemplate.query(sql, new UserMapper());

        return users.size() > 0 ? users.get(0) : null;
    }

}

class UserMapper implements RowMapper<User> {

<<<<<<< HEAD:exodia/src/main/java/com/exodia/dao/UserDaoImpl.java
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User customer = new User();
=======
  @Override
  public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
    Customer customer = new Customer();
>>>>>>> 948653c7047f5286bec97ed5c6f710522deedf2e:exodia/src/main/java/com/exodia/dao/CustomerDaoImpl.java
    /*galiba jsp den gelen yazılar*/

    customer.setUsername(rs.getString("username"));
    customer.setPassword(rs.getString("password"));
    customer.setName(rs.getString("name"));
    customer.setSurname(rs.getString("surname"));
    customer.setDateofbirth(rs.getDate("dateofbirth"));
    customer.setGender(rs.getString("gender"));
    customer.setEmail(rs.getString("email"));
    customer.setAddress(rs.getString("address"));
    customer.setPhonenumber(rs.getString("phonenumber"));

    return customer;
  }
}