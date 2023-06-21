package com.dms.document_management.dao;
package com.dms.document_management.dao

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
    
}
