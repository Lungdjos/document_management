package com.dms.document_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.document_management.models.Role;

public interface RolesDao implements JpaRepository<Role, Long> {
    
}
