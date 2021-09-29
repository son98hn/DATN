package com.example.datn.service;

import com.example.datn.dto.FunctionDTO;
import com.example.datn.entity.FunctionEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFunctionService {
    void saveFunction(FunctionDTO functionDTO);

    void delete(long[] ids);

//    List<RoleDetailEntity> findAll(Pageable pageable);

    List<FunctionEntity> findAll();

    int totalItem();

    List<FunctionEntity> findRoleByUserName(String userName);

    List<FunctionEntity> findRoleByGroupRoleId(Long id_long);

//    List<RoleDetailEntity> findRoleByRoleId(Long id_long);

    FunctionEntity findById(Long id);

    List<FunctionEntity> findRoleDetail(Pageable pageable);
}
