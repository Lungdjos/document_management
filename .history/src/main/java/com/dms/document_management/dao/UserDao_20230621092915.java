package com.dms.document_management.dao;
package com.dms.document_management.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dms.document_management.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
    
}
