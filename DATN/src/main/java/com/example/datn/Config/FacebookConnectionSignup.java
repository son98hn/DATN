//package com.example.datn.Config;
//
//import com.example.datn.entity.UserEntity;
//import com.example.datn.repository.UserRepository;
//import org.springframework.social.connect.Connection;
//import org.springframework.social.connect.ConnectionSignUp;
//import org.springframework.stereotype.Service;
//
//import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
//
///**
// * @author: Pham Ngoc Son
// * <p>
// * Sep 30, 2021
// */
//@Service
//public class FacebookConnectionSignup implements ConnectionSignUp {
//    private final UserRepository userRepository;
//
//    public FacebookConnectionSignup(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public String execute(Connection<?> connection) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername(connection.getDisplayName());
//        userEntity.setPassword(randomAlphabetic(8));
//        userRepository.save(userEntity);
//        return userEntity.getUsername();
//    }
//}
