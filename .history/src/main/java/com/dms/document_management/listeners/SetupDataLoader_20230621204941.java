package com.dms.document_management.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.dms.document_management.dao.RolesDao;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private boolean alreadySetup = false;
    private UserDao userDao;
    private RolesDao rolesDao;
    private Pri userRolesDao;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onApplicationEvent'");
    }
}
