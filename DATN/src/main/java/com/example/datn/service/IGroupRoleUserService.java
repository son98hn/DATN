package com.example.datn.service;

import com.example.datn.dto.GroupRoleUserDTO;
import com.example.datn.entity.GroupRoleUserEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupRoleUserService {
    GroupRoleUserEntity save(GroupRoleUserDTO groupRoleUserDTO);
    void delete(long[] ids);
//    List<GroupRoleUserEntity> findAll(Pageable pageable);
    List<GroupRoleUserEntity> findAll();
    int totalItem();
}
