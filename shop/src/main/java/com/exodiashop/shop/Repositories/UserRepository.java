package com.exodiashop.shop.Repositories;

import com.exodiashop.shop.Model.User;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findFirstUserByUsernameAndPassword(String userName, String password);
    @Override
    List<User> findAll();
    User findByUsername(String username);

}
