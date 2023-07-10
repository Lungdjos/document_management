package com.dms.document_management.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.dms.document_management.dao.PrivilegesDao;
import com.dms.document_management.dao.RolesDao;
import com.dms.document_management.dao.UserDao;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private boolean alreadySetup = false;
    private UserDao userDao;
    private RolesDao rolesDao;
    private PrivilegesDao privilegesDao;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onApplicationEvent'");
    }
}
