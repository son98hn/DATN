package com.example.datn.service;

import com.example.datn.dto.GroupRoleDTO;
import com.example.datn.entity.GroupRoleEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupRoleService {
    GroupRoleEntity save(GroupRoleDTO groupRoleDTO);
    void delete(long[] ids);
//    List<GroupRoleEntity> findAll(Pageable pageable);
    List<GroupRoleEntity> findAll();
    int totalItem();
    List<GroupRoleEntity> findGroupRoleByUserName(String userName);
    GroupRoleEntity findById(Long id);
    List<GroupRoleEntity> findGroupRole(Pageable pageable);
}
