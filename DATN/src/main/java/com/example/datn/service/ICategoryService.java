package com.example.datn.service;

import com.example.datn.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    List<CategoryEntity> findAll();

    CategoryEntity findById(long id);
}
