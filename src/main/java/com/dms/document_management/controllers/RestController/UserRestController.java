package com.dms.document_management.controllers.RestController;

import com.dms.document_management.dto.confis.AuthRequestDto;
import com.dms.document_management.dto.confis.JwtResponseToken;
import com.dms.document_management.dto.user.UserInfoDto;
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

@RestController
@RequestMapping(value = "/api/dms")
public class UserRestController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
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
}
