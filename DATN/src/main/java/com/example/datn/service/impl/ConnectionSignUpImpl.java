package com.example.datn.service.impl;

import com.example.datn.entity.UserEntity;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * @author: Pham Ngoc Son
 * <p>
 * Oct 04, 2021
 */
public class ConnectionSignUpImpl implements ConnectionSignUp {

    private final UserService userService;

    public ConnectionSignUpImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(Connection<?> connection) {
        UserEntity user = userService.createSocialUser(connection);
        return user.getUsername();
    }
}
