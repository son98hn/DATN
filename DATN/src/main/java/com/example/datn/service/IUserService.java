package com.example.datn.service;

import com.example.datn.dto.UserDTO;
import com.example.datn.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService {
    UserEntity save(UserDTO userDTO);
    void delete(long[] ids);
    List<UserEntity> findAll();
    int totalItem();
    UserEntity findByUserName(String userName);
    UserEntity findById(Long id);
    List<UserEntity> findUser(Pageable pageable);
}