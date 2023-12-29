package com.dms.document_management.listeners;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dms.document_management.dao.RolesDao;
import com.dms.document_management.dao.UserDao;
import com.dms.document_management.models.Role;
import com.dms.document_management.models.User;

import jakarta.transaction.Transactional;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private boolean alreadySetup = false;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RolesDao rolesDao;
    @Autowired
    private PrivilegesDao privilegesDao;
    @Autowired
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
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
 
        Privilege privilege = privilegesDao.findByName(name);
        if (privilege == null) {
            var privileg = new Privilege();
            privileg.setName(name);
            privilegesDao.save(privileg);
            privilege = privileg;
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
      String name, Collection<Privilege> privileges) {
 
        Role role = rolesDao.findByName(name);
        if (role == null) {
            var role1 = new Role();
            role1.setName(name);
            role1.setPrivileges(privileges);
            rolesDao.save(role1);
            role = role1;
        }
        return role;
    }
}
