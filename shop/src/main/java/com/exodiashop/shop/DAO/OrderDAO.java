package com.exodiashop.shop.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

public class OrderDAO  extends JdbcDaoSupport {
    @Autowired
    DataSource datasource;
}
