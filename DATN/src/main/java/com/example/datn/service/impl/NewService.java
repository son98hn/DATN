package com.example.datn.service.impl;

import com.example.datn.dto.NewDTO;
import com.example.datn.entity.CategoryEntity;
import com.example.datn.entity.NewEntity;
import com.example.datn.repository.CategoryRepository;
import com.example.datn.repository.NewRepository;
import com.example.datn.service.INewService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewService implements INewService {
    private final NewRepository newRepository;

    private final CategoryRepository categoryRepository;

    public NewService(NewRepository newRepository, CategoryRepository categoryRepository) {
        this.newRepository = newRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveNew(NewDTO newDTO) {
        if (newDTO.getId() != null) {
            if(!verifyNew(newDTO.getTitle(), newDTO.getContent())) {
                NewEntity oldNewEntity = newRepository.findById(newDTO.getId()).get();
                oldNewEntity.setModifiedBy(newDTO.getModifiedBy());
                oldNewEntity.setModifiedDate(LocalDateTime.now());
//                oldNewEntity.setModifiedBy();
                oldNewEntity.setTitle(newDTO.getTitle());
                oldNewEntity.setContent(newDTO.getContent());
                oldNewEntity.setThumbnail(newDTO.getThumbnail());
                oldNewEntity.setShortDescription(newDTO.getShortDescription());
                oldNewEntity.setStatus(1);
                CategoryEntity categoryEntity = categoryRepository.findById(newDTO.getCategoryId()).get();
                oldNewEntity.setCategoryEntity(categoryEntity);
                newRepository.save(oldNewEntity);
                newDTO.setMessage("Cập nhật bài viết thành công");
            } else {
                newDTO.setMessage("Bài viết đã tồn tại");
            }
        } else {
            if(!verifyNew(newDTO.getTitle(), newDTO.getContent())) {
                NewEntity newEntity = new NewEntity();
                newEntity.setCreatedBy(newDTO.getCreatedBy());
                newEntity.setCreatedDate(LocalDateTime.now());
                newEntity.setTitle(newDTO.getTitle());
                newEntity.setContent(newDTO.getContent());
                newEntity.setThumbnail(newDTO.getThumbnail());
                newEntity.setStatus(0);
                newEntity.setShortDescription(newDTO.getShortDescription());
                CategoryEntity categoryEntity = categoryRepository.findById(newDTO.getCategoryId()).get();
                newEntity.setCategoryEntity(categoryEntity);
                newRepository.save(newEntity);
                newDTO.setMessage("Thêm bài viết thành công");
            } else {
                newDTO.setMessage("Bài viết đã tồn tại");
            }
        }
    }

    private Boolean verifyNew(String title, String content) {
        return newRepository.existsByTitleAndContent(title, content);
    }



//    @Override
//    public List<NewEntity> findAll(Pageable pageable) {
//        List<NewEntity> results = new ArrayList<>();
//        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
//        return results;
//    }

    @Override
    public int totalItemActive() {
        return (int) newRepository.totalItemActive();
    }

    @Override
    public int totalItemDeactive() {
        return (int) newRepository.totalItemDeactive();
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
    public List<NewEntity> findAllActive(Pageable pageable) {
        return newRepository.findAllActive(pageable);
    }

    @Override
    public List<NewEntity> findAllDeactive(Pageable pageable) {
        return newRepository.findAllDeactive(pageable);
    }

    @Override
    public int totalItemByCategoryParent(String categoryParent) {
        return (int) newRepository.totalItemByCategoryParent(categoryParent);
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
    public void delete(long[] ids) {
        for (long item : ids) {
            newRepository.removeById(item);
        }
    }
}
