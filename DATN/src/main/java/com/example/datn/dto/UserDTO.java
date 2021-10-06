package com.example.datn.dto;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractDTO<UserDTO> {
    private Long userId;
    private String username;
    private List<String> groupName;
    //    private Integer status;
    private String email;
    private String phone;
    private String name;
    private String avatar;
    private String signInProvider;
    private String providerUserId;
    private String password;
    private String confirmPassword;

    public UserDTO() {
    }

    public UserDTO(Connection<?> connection) {
        UserProfile userProfile = connection.fetchUserProfile();
        this.userId = null;
        this.email = userProfile.getEmail();
        this.username = userProfile.getUsername();
        this.name = userProfile.getLastName();
        ConnectionKey key = connection.getKey();
//        gg, fb
        this.signInProvider=key.getProviderId();
        // ID of User on google, facebook, twitter.
        // ID của User trên google, facebook, twitter.
        this.providerUserId = key.getProviderUserId();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<String> getGroupName() {
        return groupName;
    }

    public void setGroupName(List<String> groupName) {
        this.groupName = groupName;
    }

    public String getSignInProvider() {
        return signInProvider;
    }

    public void setSignInProvider(String signInProvider) {
        this.signInProvider = signInProvider;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }
}
