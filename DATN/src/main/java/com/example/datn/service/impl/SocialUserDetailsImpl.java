package com.example.datn.service.impl;

import com.example.datn.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: Pham Ngoc Son
 * <p>
 * Oct 04, 2021
 */
public class SocialUserDetailsImpl implements SocialUserDetails {

    private final List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();

    private final UserEntity user;

    public SocialUserDetailsImpl(UserEntity user, List<String> roleNames) {
        this.user = user;
        for (String roleName : roleNames) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
            this.grantedAuthorityList.add(grantedAuthority);
        }
    }

    @Override
    public String getUserId() {
        return this.user.getId()+"";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
