package com.dms.document_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dms.document_management.models.user.UserInfo;

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Long>{

    UserInfo findByUsername(String username);
    
}
