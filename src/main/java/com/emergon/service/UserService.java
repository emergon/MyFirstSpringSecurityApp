package com.emergon.service;

import com.emergon.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    public User findByUsername(String username);

    public void save(User user);
    
}
