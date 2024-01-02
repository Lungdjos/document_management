package com.dms.document_management.managers.implementation.user;

import com.dms.document_management.dao.RolesDao;
import com.dms.document_management.dao.UserInfoDao;
import com.dms.document_management.dto.user.UserInfoDto;
import com.dms.document_management.models.roles.Role;
import com.dms.document_management.models.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dms.document_management.managers.UserInfoManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Log4j2
@Service
@Primary
public class UserInfoManagerImpl implements UserInfoManager {
    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private RolesDao rolesDao;
    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();
    }

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

    @Override
    public void createUser(UserInfoDto userInfoDto) throws Exception {
        try{
            var user = userInfoDao.findByUsername(userInfoDto.getUsername());
            if (Objects.nonNull(user)) {
                log.error("User with this username {} already exists!", userInfoDto.getUsername());
                throw new Exception("User found err.");
            }
            UserInfo newUser = new UserInfo();
            newUser.setFName(userInfoDto.getFName());
            newUser.setLName(userInfoDto.getLName());
            newUser.setMName(userInfoDto.getMName());
            newUser.setUsername(userInfoDto.getUsername());
            newUser.setEmail(userInfoDto.getEmail());
            newUser.setPassword(passwordEncoder().encode(userInfoDto.getPassword()));
            Set<Role> roles = rolesDao.findByNameIn(userInfoDto.getRoles());;
            newUser.setRoles(roles);

            userInfoDao.save(newUser);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
