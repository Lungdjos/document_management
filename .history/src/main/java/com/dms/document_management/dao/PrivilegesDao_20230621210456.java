package com.dms.document_management.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dms.document_management.model.Privilege;
@Repository
public interface PrivilegesDao extends JpaRepository<Privilege, Long>{

    Privilege findByName(String name);
    
}
