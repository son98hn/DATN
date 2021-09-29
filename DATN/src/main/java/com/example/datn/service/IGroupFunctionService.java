package com.example.datn.service;

import com.example.datn.dto.GroupFunctionDTO;
import com.example.datn.entity.GroupFunctionEntity;

import java.util.List;

public interface IGroupFunctionService {
    void saveGroupFunction(GroupFunctionDTO GroupFunctionDTO);

    void delete(long[] ids);

    //    List<GroupRoleDetailEntity> findAll(Pageable pageable);
    List<GroupFunctionEntity> findAll();

    int totalItem();

    void deleteGroupFunctionByGroupId(Long id);
}
