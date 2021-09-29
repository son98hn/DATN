package com.example.datn.service;

import com.example.datn.dto.UserDTO;
import com.example.datn.entity.UserEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    void saveUser(UserDTO userDTO);

    void delete(long[] ids);

    List<UserEntity> findAll();

    int totalItem();

    UserEntity findByUserName(String userName);

    UserEntity findById(Long id);

    List<UserEntity> findUser(Pageable pageable);
}
