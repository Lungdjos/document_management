package com.dms.document_management.managers.implementation.role;

import com.dms.document_management.dao.RolesDao;
import com.dms.document_management.managers.RoleManager;
import com.dms.document_management.models.roles.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoleManagerImpl implements RoleManager {
    @Autowired
    private RolesDao rolesDao;
    @Override
    public void addNewRole(String role) {

    }

    @Override
    public Role getRole(String role) throws Exception {
        var availableRole = rolesDao.findByName(role);
        if (Objects.nonNull(availableRole)){
            return availableRole;
        }else {
            throw new Exception("This role " + "role"+" does not exist, consider adding a new one...!");
        }
    }
}
