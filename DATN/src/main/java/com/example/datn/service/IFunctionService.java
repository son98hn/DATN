package com.example.datn.service;

import com.example.datn.dto.FunctionDTO;
import com.example.datn.entity.FunctionEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFunctionService {
    void saveFunction(FunctionDTO functionDTO);

    void delete(long[] ids);

    List<FunctionEntity> findAll();

    int totalItem();

    List<FunctionEntity> findFunctionByUserName(String userName);

    List<FunctionEntity> findFunctionByGroupId(Long id_long);

    FunctionEntity findById(Long id);

    List<FunctionEntity> findFunction(Pageable pageable);
}
