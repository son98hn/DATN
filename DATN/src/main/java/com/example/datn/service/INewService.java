package com.example.datn.service;

import com.example.datn.dto.NewDTO;
import com.example.datn.entity.NewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService {
    NewEntity save(NewDTO newDTO);
    void delete(long[] ids);
    List<NewEntity> findAll(Pageable pageable);
    List<NewEntity> findAll();
    int totalItem();
    NewEntity findById(Long id);
    List<NewEntity> findNewsByCategoryParentCode(String categoryParentCode, Pageable pageable);
    List<NewEntity> findNewsByCategoryParentCode1(String categoryParentCode);
    List<NewEntity> findNew(Pageable pageable);
    int totalItemByCategoryParent(String categoryParent);
    NewEntity findTopByCategoryParentCode(String categoryParentCode);
    NewEntity findByTitle(String title);
}
