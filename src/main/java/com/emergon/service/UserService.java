package com.emergon.service;

import com.emergon.entities.User;

public interface UserService {

    public User findByUsername(String username);

    public void save(User user);
    
}
