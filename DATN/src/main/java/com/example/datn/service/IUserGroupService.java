package com.example.datn.service;

import com.example.datn.dto.UserGroupDTO;
import com.example.datn.entity.UserGroupEntity;

import java.util.List;

public interface IUserGroupService {
    void saveUserGroup(UserGroupDTO userGroupDTO);

    void delete(long[] ids);

    List<UserGroupEntity> findAll();

    int totalItem();
}
