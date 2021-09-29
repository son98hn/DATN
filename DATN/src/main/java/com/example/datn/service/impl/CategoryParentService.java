package com.example.datn.service.impl;

import com.example.datn.entity.CategoryParentEntity;
import com.example.datn.repository.CategoryParentRepository;
import com.example.datn.service.ICategoryParentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryParentService implements ICategoryParentService {


    private final CategoryParentRepository categoryParentRepository;

    public CategoryParentService(CategoryParentRepository categoryParentRepository) {
        this.categoryParentRepository = categoryParentRepository;
    }

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
