package com.example.datn.Utils;

import com.example.datn.entity.UserEntity;
import com.example.datn.service.impl.SocialUserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.security.SocialUserDetails;

import java.util.List;

/**
 * @author: Pham Ngoc Son
 * <p>
 * Oct 04, 2021
 */
public class SecurityUtil  {
    public static void loginUser(UserEntity user, List<String> roleNames) {
        SocialUserDetails socialUserDetails = new SocialUserDetailsImpl(user, roleNames);
        Authentication authentication = new UsernamePasswordAuthenticationToken(socialUserDetails, null, socialUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
