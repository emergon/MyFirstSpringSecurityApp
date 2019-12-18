package com.emergon.dao;

import com.emergon.entities.User;

public interface UserDao {

    public User findByUsername(String username);

    public void save(User user);
    
}
