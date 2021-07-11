package com.example.datn.service.impl;


import com.example.datn.dto.UserDTO;
import com.example.datn.entity.GroupRoleUserEntity;
import com.example.datn.entity.UserEntity;
import com.example.datn.repository.GroupRoleRepository;
import com.example.datn.repository.GroupRoleUserRepository;
import com.example.datn.repository.UserRepository;
import com.example.datn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRoleRepository groupRoleRepository;
    @Autowired
    private GroupRoleUserRepository groupRoleUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserEntity save(UserDTO userDTO) {
        if (userDTO.getId() != null) {
            groupRoleUserRepository.deleteByUserId(userDTO.getId());
            UserEntity oldUserEntity = userRepository.findById(userDTO.getId()).get();
            return getUserEntity(userDTO, oldUserEntity);
        } else {
            UserEntity userEntity = new UserEntity();
            return getUserEntity(userDTO, userEntity);
        }
    }

    private UserEntity getUserEntity(UserDTO userDTO, UserEntity userEntity) {
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userEntity);
        for (int i = 0; i < userDTO.getGroupRoleName().size(); i++) {
            GroupRoleUserEntity groupRoleUserEntity = new GroupRoleUserEntity();
            groupRoleUserEntity.setUserEntity(userEntity);
            groupRoleUserEntity.setGroupRoleEntity(groupRoleRepository.findByName(userDTO.getGroupRoleName().get(i)));
            groupRoleUserRepository.save(groupRoleUserEntity);
        }
        return userRepository.findById(userEntity.getId()).get();
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            UserEntity userEntity = userRepository.findById(item).get();
            groupRoleUserRepository.deleteByUserId(userEntity.getId());
            userRepository.deleteById(item);
        }
    }
    @Override
    public int totalItem() {
        return (int) userRepository.count();
    }

    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserEntity> findUser(Pageable pageable) {
        return userRepository.findUser(pageable);
    }
}
