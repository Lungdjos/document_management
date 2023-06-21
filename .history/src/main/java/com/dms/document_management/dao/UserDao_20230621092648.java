package com.dms.document_management.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao implements JpaRepository<User, Long>{
    
}
