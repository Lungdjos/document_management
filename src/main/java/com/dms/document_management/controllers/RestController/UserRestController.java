package com.dms.document_management.controllers.RestController;

import com.dms.document_management.dto.confis.AuthRequestDto;
import com.dms.document_management.dto.confis.JwtResponseToken;
import com.dms.document_management.dto.user.UserInfoDto;
import com.dms.document_management.managers.UserInfoManager;
import com.dms.document_management.managers.implementation.configs.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/dms")
public class UserRestController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserInfoManager userInfoManager;
    @PostMapping(value = "/login")
    public JwtResponseToken aunthenticateAndGetToken(@RequestBody AuthRequestDto authRequestDto){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));

        if (authentication.isAuthenticated()){
            return JwtResponseToken.builder()
                    .accessToken(jwtService.generateToken(authRequestDto.getUsername())).build();
        } else {
            throw new UsernameNotFoundException("Invalid user request...!");
        }
    }
    @PostMapping(value = "/register")
    public Map<String,Object> registerUser(UserInfoDto userInfoDto){
        Map<String, Object> map = new HashMap<>();
        try {
            userInfoManager.createUser(userInfoDto);
            map.put("status", "SUCCESS");
            map.put("message", "User created successfully");

            return map;
        } catch (Exception e) {
            map.put("status", "ERROR");
            map.put("message", "User could not be created successfully!");
            return map;
        }
    }
}
