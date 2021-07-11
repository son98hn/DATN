package com.example.datn.service.impl;

import com.example.datn.dto.NewDTO;
import com.example.datn.entity.CategoryEntity;
import com.example.datn.entity.NewEntity;
import com.example.datn.repository.CategoryRepository;
import com.example.datn.repository.NewRepository;
import com.example.datn.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {
    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public NewEntity save(NewDTO newDTO) {
        NewEntity newEntity = new NewEntity();
        if (newDTO.getId() != null) {
            NewEntity oldNewEntity = newRepository.findById(newDTO.getId()).get();
            oldNewEntity.setModifiedDate(new Timestamp(System.currentTimeMillis()));
            oldNewEntity.setTitle(newDTO.getTitle());
            oldNewEntity.setContent(newDTO.getContent());
            oldNewEntity.setThumbnail(newDTO.getThumbnail());
            oldNewEntity.setShortDescription(newDTO.getShortDescription());
            CategoryEntity categoryEntity = categoryRepository.findById(newDTO.getCategoryId()).get();
            oldNewEntity.setCategoryEntity(categoryEntity);
            newRepository.save(oldNewEntity);
            return newRepository.findById(oldNewEntity.getId()).get();
        } else {
            newEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            newEntity.setTitle(newDTO.getTitle());
            newEntity.setContent(newDTO.getContent());
            newEntity.setThumbnail(newDTO.getThumbnail());
            newEntity.setShortDescription(newDTO.getShortDescription());
            CategoryEntity categoryEntity = categoryRepository.findById(newDTO.getCategoryId()).get();
            newEntity.setCategoryEntity(categoryEntity);
            NewEntity newId = newRepository.save(newEntity);
            return newRepository.findById(newId.getId()).get();
        }

    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            newRepository.removeById(item);
        }
    }

    @Override
    public List<NewEntity> findAll(Pageable pageable) {
        List<NewEntity> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        return results;
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }

    @Override
    public NewEntity findById(Long id) {
        return newRepository.findById(id).get();
    }

    @Override
    public List<NewEntity> findNewsByCategoryParentCode(String categoryParentCode, Pageable pageable) {
        return newRepository.findNewsByCategoryParentCode(categoryParentCode, pageable);
    }

    @Override
    public List<NewEntity> findNewsByCategoryParentCode1(String categoryParentCode) {
        return newRepository.findNewsByCategoryParentCode1(categoryParentCode);
    }

    @Override
    public List<NewEntity> findNew(Pageable pageable) {
        return newRepository.findNew(pageable);
    }

    @Override
    public int totalItemByCategoryParent(String categoryParent) {
        return (int)newRepository.totalItemByCategoryParent(categoryParent);
    }

    @Override
    public NewEntity findTopByCategoryParentCode(String categoryParentCode) {
        return newRepository.findTopByCategoryParentCode(categoryParentCode);
    }

    @Override
    public NewEntity findByTitle(String title) {
        return newRepository.findByTitle(title);
    }

    @Override
    public List<NewEntity> findAll() {
        return newRepository.findAll();
    }
}
