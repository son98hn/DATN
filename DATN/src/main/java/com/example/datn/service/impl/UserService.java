package com.example.datn.service.impl;


import com.example.datn.dto.UserDTO;
import com.example.datn.entity.GroupEntity;
import com.example.datn.entity.UserEntity;
import com.example.datn.entity.UserGroupEntity;
import com.example.datn.repository.GroupRepository;
import com.example.datn.repository.UserGroupRepository;
import com.example.datn.repository.UserRepository;
import com.example.datn.service.IUserService;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final UserGroupRepository userGroupRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final String DefaultPassword = "Abc@12345678";
    private final
    EntityManager entityManager;
    private final UserGroupService userGroupService;

    public UserService(UserRepository userRepository, GroupRepository groupRepository, UserGroupRepository userGroupRepository, BCryptPasswordEncoder bCryptPasswordEncoder, EntityManager entityManager, UserGroupService userGroupService) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.userGroupRepository = userGroupRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.entityManager = entityManager;
        this.userGroupService = userGroupService;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        if (userDTO.getId() == null) {
            if (!verifyUser(userDTO.getUsername(), userDTO.getPhone(), userDTO.getEmail())) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(userDTO.getUsername());
                userEntity.setPassword(bCryptPasswordEncoder.encode(DefaultPassword));
                userEntity.setEmail(userDTO.getEmail());
                userEntity.setPhone(userDTO.getPhone());
                userEntity.setName(userDTO.getName());
                userRepository.save(userEntity);
                for (int i = 0; i < userDTO.getGroupName().size(); i++) {
                    UserGroupEntity userGroupEntity = new UserGroupEntity();
                    userGroupEntity.setUserEntity(userEntity);
                    userGroupEntity.setGroupEntity(groupRepository.findByName(userDTO.getGroupName().get(i)));
                    userGroupRepository.save(userGroupEntity);
                }
                userDTO.setMessage("Tạo tài khoản thành công");
            } else {
                userDTO.setMessage("Tải khoản đã được sử dụng");
            }
        } else {
            if (!verifyUser(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPhone())) {
                UserEntity oldUser = userRepository.findById(userDTO.getId()).get();
                oldUser.setEmail(userDTO.getEmail());
                oldUser.setPhone(userDTO.getPhone());
                oldUser.setName(userDTO.getName());
                userRepository.save(oldUser);
                for (int i = 0; i < userDTO.getGroupName().size(); i++) {
                    UserGroupEntity userGroupEntity = new UserGroupEntity();
                    userGroupEntity.setUserEntity(oldUser);
                    userGroupEntity.setGroupEntity(groupRepository.findByName(userDTO.getGroupName().get(i)));
                    userGroupRepository.save(userGroupEntity);
                }
                userDTO.setMessage("Cập nhật tài khoản thành công!");
            } else {
                userDTO.setMessage("Số điện thoại hoặc Email đã tồn tại!");
            }
        }
    }

    private Boolean verifyUser(String userName, String email, String phone) {
        return userRepository.existsByUsernameOrEmailOrPhone(userName, email, phone);
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            UserEntity userEntity = userRepository.findById(item).get();
            userGroupRepository.deleteByUserEntityId(userEntity.getId());
            userRepository.deleteById(item);
        }
    }

    @Override
    public void resetPassword(long[] ids) {
        for (long item : ids) {
            UserEntity userEntity = userRepository.findById(item).get();
            userEntity.setPassword(bCryptPasswordEncoder.encode(DefaultPassword));
            userRepository.save(userEntity);
        }
    }

    @Override
    public int totalItem() {
        return (int) userRepository.count();
    }

    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findByUsername(userName);
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


    @Override
    public UserEntity createSocialUser(Connection<?> connection) {
        ConnectionKey connectionKey = connection.getKey();
        UserProfile userProfile = connection.fetchUserProfile();
        String email = userProfile.getEmail();
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            return userEntity;
        }
        String username_prefix = userProfile.getFirstName().trim().toLowerCase() + "_" + userProfile.getLastName().trim().toLowerCase();
        String username = userRepository.findByUsername(username_prefix).getUsername();
        String randomPassword = UUID.randomUUID().toString().substring(0, 5);
        String bCryptPassword = bCryptPasswordEncoder.encode(randomPassword);
        UserEntity user = new UserEntity();
        user.setPassword(bCryptPassword);
        user.setUsername(username);
        user.setEmail(email);
        user.setName(userProfile.getLastName());
        entityManager.persist(user);
        UserGroupEntity userGroupEntity = new UserGroupEntity();
        GroupEntity groupEntity = groupRepository.findByName("user");
        userGroupEntity.setGroupEntity(groupEntity);
        userGroupEntity.setUserEntity(user);
        userGroupRepository.save(userGroupEntity);
        return user;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private Boolean verifyRegister(String password, String confirmPassword) {
        return (password.equals(confirmPassword));
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        if (verifyRegister(userDTO.getPassword(), userDTO.getConfirmPassword()) && !verifyUser(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPhone())) {
            UserEntity user = new UserEntity();
            user.setUsername(userDTO.getUsername());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
            userRepository.save(user);
            UserGroupEntity userGroupEntity = new UserGroupEntity();
            userGroupEntity.setUserEntity(user);
            userGroupEntity.setGroupEntity(groupRepository.findByCode("user"));
            userGroupRepository.save(userGroupEntity);
            userDTO.setMessage("Đăng ký tài khoản thành công");
        } else {
            userDTO.setMessage("Đăng ký tài khoản thất bại");
        }
    }
}
