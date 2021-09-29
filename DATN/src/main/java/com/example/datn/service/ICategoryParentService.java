package com.example.datn.service;

import com.example.datn.entity.CategoryParentEntity;

import java.util.List;

public interface ICategoryParentService {
    List<CategoryParentEntity> findAll();

    CategoryParentEntity findById(long id);

    CategoryParentEntity findByCode(String code);
}
