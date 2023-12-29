package com.dms.document_management.managers.implementation.user;

import com.dms.document_management.dao.UserInfoDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dms.document_management.managers.UserInfoManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Log4j2
@Service
public class UserInfoManagerImpl implements UserInfoManager {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Into the user manager");
        var user = userInfoDao.findByUsername(username);
        if (Objects.isNull(user)){
            log.error("Username {} not found", username);
            throw new UsernameNotFoundException("Could not load user");
        }
        log.info("User Authenticated Successfully..!!!");
        return new CustomUserDetailsImpl(user);
    }
}
