package com.example.datn.service;

import com.example.datn.dto.RoleDetailDTO;
import com.example.datn.entity.RoleDetailEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRoleDetailService {
    RoleDetailEntity save(RoleDetailDTO roleDetailDTO);

    void delete(long[] ids);

//    List<RoleDetailEntity> findAll(Pageable pageable);

    List<RoleDetailEntity> findAll();

    int totalItem();

    List<RoleDetailEntity> findRoleByUserName(String userName);

    List<RoleDetailEntity> findRoleByGroupRoleId(Long id_long);

//    List<RoleDetailEntity> findRoleByRoleId(Long id_long);

    RoleDetailEntity findById(Long id);

    List<RoleDetailEntity> findRoleDetail(Pageable pageable);
}
