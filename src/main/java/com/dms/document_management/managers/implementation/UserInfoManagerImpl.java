package com.dms.document_management.managers.implementation;

import com.dms.document_management.dao.UserInfoDao;
import com.dms.document_management.managers.CustomUserDetails;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dms.document_management.managers.UserInfoManager;

import java.util.Objects;

@Log4j2
@AllArgsConstructor
public class UserInfoManagerImpl implements UserInfoManager, UserDetailsService {
    private final UserInfoDao userInfoDao;
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
