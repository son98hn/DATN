package com.example.datn.service.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author: Pham Ngoc Son
 * <p>
 * Oct 04, 2021
 */
@Service
public class SocialUserDetailsServiceImpl implements SocialUserDetailsService {

    private final UserDetailsServiceImpl userDetailsService;

    public SocialUserDetailsServiceImpl(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException, DataAccessException {
        System.out.println("SocialUserDetailsServiceImpl.loadUserByUserId=" + username);
        UserDetails userDetails = ((UserDetailsServiceImpl) userDetailsService).loadUserByUsername(username);
        return (SocialUserDetails) userDetails;
    }

}
