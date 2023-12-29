package com.dms.document_management.managers.implementation;

import com.dms.document_management.managers.CustomUserDetails;
import com.dms.document_management.model.Role;
import com.dms.document_management.model.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetailsImpl extends UserInfo implements CustomUserDetails {
    Collection<? extends GrantedAuthority> authorities;
    public CustomUserDetailsImpl(UserInfo user) {
        List<GrantedAuthority> authority = new ArrayList<>();

        for(Role role : user.getRoles()){
            authority.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }
        this.authorities = authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
