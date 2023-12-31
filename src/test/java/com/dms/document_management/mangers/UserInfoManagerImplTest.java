package com.dms.document_management.mangers;

import com.dms.document_management.dao.RolesDao;
import com.dms.document_management.managers.UserInfoManager;
import com.dms.document_management.managers.implementation.user.UserInfoManagerImpl;
import com.dms.document_management.dao.UserInfoDao;
import com.dms.document_management.models.user.UserInfo;
import com.dms.document_management.models.roles.Role;
import com.dms.document_management.dto.user.UserInfoDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserInfoManagerImplTest {
    @Mock
    private RolesDao rolesDao;
    @Mock
    private UserInfoDao userInfoDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserInfoManager userInfoManager = new UserInfoManagerImpl();

    @Test
    void testCreateUser() throws Exception {
        // Mock data
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setFName("John");
        userInfoDto.setLName("Doe");
        userInfoDto.setMName("Middle");
        userInfoDto.setUsername("john.doe");
        userInfoDto.setEmail("john.doe@example.com");
        userInfoDto.setPassword("password");
        userInfoDto.setRole(rolesDao.findByName("ROLE_USER"));  // Assuming a role name

        Role mockRole = new Role();
        mockRole.setId(1L);
        mockRole.setName("ROLE_USER");

        // Mocking behavior
        when(userInfoDao.findByUsername("john.doe")).thenReturn(null);  // No existing user
        when(passwordEncoder.encode("password")).thenReturn("hashedPassword");
        when(userInfoDao.save(any(UserInfo.class))).thenReturn(new UserInfo());

        // Test the createUser method
        userInfoManager.createUser(userInfoDto);

        // Verify interactions
        verify(userInfoDao, times(1)).findByUsername("john.doe");
        verify(passwordEncoder, times(1)).encode("password");
        verify(userInfoDao, times(1)).save(any(UserInfo.class));
    }

    @Test
    void testCreateUserExistingUser() {
        // Mock data
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUsername("john.doe");

        // Mocking behavior
        when(userInfoDao.findByUsername("john.doe")).thenReturn(new UserInfo());

        // Test the createUser method with an existing user
        assertThrows(Exception.class, () -> userInfoManager.createUser(userInfoDto));

        // Verify interactions
        verify(userInfoDao, times(1)).findByUsername("john.doe");
        verifyNoMoreInteractions(passwordEncoder, userInfoDao);
    }
}