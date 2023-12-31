package com.dms.document_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dms.document_management.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

    Object findByUsername(String username);
    
}
