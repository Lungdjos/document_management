package com.dms.document_management.listeners;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dms.document_management.dao.PrivilegesDao;
import com.dms.document_management.dao.RolesDao;
import com.dms.document_management.dao.UserDao;
import com.dms.document_management.model.Privilege;
import com.dms.document_management.model.Role;
import com.dms.document_management.model.User;

import jakarta.transaction.Transactional;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private boolean alreadySetup = false;
    private UserDao userDao;
    private RolesDao rolesDao;
    private PrivilegesDao privilegesDao;
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
 
        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = rolesDao.findByName("ROLE_ADMIN");
        User user = new User();
        user.setFName("Test");
        user.setLName("Test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        userDao.save(user);

        alreadySetup = true;
        throw new UnsupportedOperationException("Unimplemented method 'onApplicationEvent'");
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
 
        Privilege privilege = privilegesDao.findByName(name);
        if (privilege == null) {
            privilege.s;
            privilegesDao.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
      String name, Collection<Privilege> privileges) {
 
        Role role = rolesDao.findByName(name);
        if (role == null) {
            Role role = new Role();
            role.setName(name);
            role.setPrivileges(privileges);
            rolesDao.save(role);
        }
        return role;
    }
}
