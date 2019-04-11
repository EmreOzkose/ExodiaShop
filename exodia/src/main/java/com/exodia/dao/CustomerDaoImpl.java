package com.exodia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.exodia.model.Login;
import com.exodia.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void register(Customer customer) {

    String sql = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] {3, customer.getUsername(), customer.getPassword(), customer.getName(),customer.getSurname(),customer.getDateofbirth(),customer.getGender(), customer.getEmail(), customer.getAddress(), customer.getPhonenumber()});
  }

  public Customer validateUser(Login login) {

    String sql = "select * from customer where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";

    List<Customer> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }

}

class UserMapper implements RowMapper<Customer> {

  public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
    Customer customer = new Customer();
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