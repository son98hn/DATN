package com.example.datn.service.impl;

import com.example.datn.dto.CategoryDTO;
import com.example.datn.entity.CategoryEntity;
import com.example.datn.repository.CategoryRepository;
import com.example.datn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity findById(long id) {
        return categoryRepository.findById(id).get();
    }

}
