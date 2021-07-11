package com.example.datn.service.impl;

import com.example.datn.entity.CategoryEntity;
import com.example.datn.entity.CategoryParentEntity;
import com.example.datn.repository.CategoryParentRepository;
import com.example.datn.repository.CategoryRepository;
import com.example.datn.service.ICategoryParentService;
import com.example.datn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryParentService implements ICategoryParentService {


    @Autowired
    private CategoryParentRepository categoryParentRepository;

    @Override
    public List<CategoryParentEntity> findAll() {
        return categoryParentRepository.findAll();
    }

    @Override
    public CategoryParentEntity findById(long id) {
        return categoryParentRepository.findById(id).get();
    }

    @Override
    public CategoryParentEntity findByCode(String code) {
        return categoryParentRepository.findByCode(code);
    }

}
