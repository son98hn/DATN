package com.example.datn.repository;

import com.example.datn.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCode(String code);
}
