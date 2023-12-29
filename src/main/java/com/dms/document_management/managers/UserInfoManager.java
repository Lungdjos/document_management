package com.dms.document_management.managers;

import com.dms.document_management.dto.user.UserInfoDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserInfoManager extends UserDetailsService {
void createUser(UserInfoDto userInfoDto) throws Exception;
}
