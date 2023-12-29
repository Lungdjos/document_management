package com.dms.document_management.managers;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public interface UserInfoManager extends UserDetailsService {
    
}
