package com.emergon.service;

import com.emergon.dao.RoleDao;
import com.emergon.entities.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDao rdao;
    
    @Override
    public List<Role> getRoles() {
        return rdao.findAll();
    }
    
}
