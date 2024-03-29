package com.emergon.config;

import com.emergon.entities.Role;
import com.emergon.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToRoleConverter implements Converter<Object, Role>{

    @Autowired
    RoleService roleService;
    
    @Override
    public Role convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        Role role = roleService.findById(id);
        return role;
    }

    
    
    
}
