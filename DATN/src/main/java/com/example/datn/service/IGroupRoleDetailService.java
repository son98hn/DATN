package com.example.datn.service;

import com.example.datn.dto.GroupRoleDetailDTO;
import com.example.datn.entity.GroupRoleDetailEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupRoleDetailService {
    GroupRoleDetailEntity save(GroupRoleDetailDTO groupRoleDetailDTO);
    void delete(long[] ids);
//    List<GroupRoleDetailEntity> findAll(Pageable pageable);
    List<GroupRoleDetailEntity> findAll();
    int totalItem();
    void deleteGroupRoleDetailByGroupRoleId(Long id);
}
