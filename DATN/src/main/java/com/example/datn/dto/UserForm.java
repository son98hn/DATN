//package com.example.datn.dto;
//
//import org.springframework.social.connect.Connection;
//import org.springframework.social.connect.ConnectionKey;
//import org.springframework.social.connect.UserProfile;
//
///**
// * @author: Pham Ngoc Son
// * <p>
// * Oct 04, 2021
// */
//public class UserForm {
//    private Long userId;
//    private String email;
//    private String userName;
//
//    private String firstName;
//    private String lastName;
//    private String password;
//    private String role;
//    private String signInProvider;
//    private String providerUserId;
//
//    public UserForm() {
//
//    }
//
//    public UserForm(Connection<?> connection) {
//        UserProfile userProfile = connection.fetchUserProfile();
//        this.userId = null;
//        this.email = userProfile.getEmail();
//        this.userName = userProfile.getUsername();
//        this.firstName = userProfile.getFirstName();
//        this.lastName = userProfile.getLastName();
//        ConnectionKey key = connection.getKey();
////        gg, fb
//        this.signInProvider=key.getProviderId();
//        // ID of User on google, facebook, twitter.
//        // ID của User trên google, facebook, twitter.
//        this.providerUserId = key.getProviderUserId();
//    }
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long id) {
//        this.userId = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String getSignInProvider() {
//        return signInProvider;
//    }
//
//    public void setSignInProvider(String signInProvider) {
//        this.signInProvider = signInProvider;
//    }
//
//    public String getProviderUserId() {
//        return providerUserId;
//    }
//
//    public void setProviderUserId(String providerUserId) {
//        this.providerUserId = providerUserId;
//    }
//}
