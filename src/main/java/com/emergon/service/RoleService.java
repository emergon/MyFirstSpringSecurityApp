package com.emergon.service;

import com.emergon.entities.Role;
import java.util.List;

public interface RoleService {

    public List<Role> getRoles();

    public Role findById(Integer id);
    
}
