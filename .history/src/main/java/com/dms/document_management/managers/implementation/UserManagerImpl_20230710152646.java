package com.dms.document_management.managers.implementation;

import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dms.document_management.dao.RolesDao;
import com.dms.document_management.dao.UserDao;
import com.dms.document_management.managers.UserManager;

public class UserManagerImpl implements UserManager, UserDetailsService {
    private UserDao userDao;
    private RolesDao rolesDao;
    private MessageSource messageSource;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user =  userDao.findByUsername(username);
        
        return null;
    }
    
}
