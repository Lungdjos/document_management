package com.dms.document_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.document_management.model.Role;

public interface RolesDao extends JpaRepository<Role, Long> {
    
}
