package com.example.datn.Config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationSuccessHandlerCustom implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>(authentication.getAuthorities());
        String url = "/trang-chu";
        for (GrantedAuthority grantedAuthority : listAuthorities){
            if (grantedAuthority.getAuthority().equals("admin")){
                url = "/admin-home";
                break;
            }
        }
        response.sendRedirect(url);
    }
}
