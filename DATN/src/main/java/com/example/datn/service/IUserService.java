package com.example.datn.service;

import com.example.datn.dto.UserDTO;
import com.example.datn.dto.UserForm;
import com.example.datn.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.social.connect.Connection;

import java.util.List;

public interface IUserService {
    void saveUser(UserDTO userDTO);

    void resetPassword(long[] ids);

    void delete(long[] ids);

    List<UserEntity> findAll();

    int totalItem();

    UserEntity findByUserName(String userName);

    UserEntity findById(Long id);

    List<UserEntity> findUser(Pageable pageable);

    UserEntity createSocialUser(Connection<?> connection);

    UserEntity findByEmail(String email);

    UserEntity registerUser(UserForm userForm);
}
