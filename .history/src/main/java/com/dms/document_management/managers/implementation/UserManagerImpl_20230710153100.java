package com.dms.document_management.managers.implementation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dms.document_management.dao.RolesDao;
import com.dms.document_management.dao.UserDao;
import com.dms.document_management.managers.UserManager;
import com.dms.document_management.model.Role;

public class UserManagerImpl implements UserManager, UserDetailsService {
    private UserDao userDao;
    private RolesDao rolesDao;
    private MessageSource messageSource;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user =  userDao.findByUsername(username);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
              " ", " ", true, true, true, true, 
              getAuthorities(Arrays.asList(
                rolesDao.findByName("ROLE_USER"))));
        } else {
            
        }
        return null;
    }
    private Collection<? extends GrantedAuthority> getAuthorities(List<String> asList) {
        return null;
    }
    
}
