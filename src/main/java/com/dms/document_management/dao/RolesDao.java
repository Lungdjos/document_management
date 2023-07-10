package com.dms.document_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dms.document_management.model.Role;

@Repository
public interface RolesDao extends JpaRepository<Role, Long> {

    Role findByName(String name);
    
}
