package com.emergon.service;

import com.emergon.dao.UserDao;
import com.emergon.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao udao;
    
    @Override
    public User findByUsername(String username) {
        return udao.findByUsername(username);
    }

    @Override
    public void save(User user) {
        udao.save(user);
    }
    
}
