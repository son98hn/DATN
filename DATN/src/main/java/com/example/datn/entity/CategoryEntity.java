package com.example.datn.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    private String code;

    private String name;

    @OneToMany(mappedBy = "categoryEntity")
    private List<NewEntity> newEntityList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_parent_id")
    private CategoryParentEntity categoryParentEntity;

    public CategoryParentEntity getCategoryParentEntity() {
        return categoryParentEntity;
    }

    public void setCategoryParentEntity(CategoryParentEntity categoryParentEntity) {
        this.categoryParentEntity = categoryParentEntity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NewEntity> getNewEntityList() {
        return newEntityList;
    }

    public void setNewEntityList(List<NewEntity> newEntityList) {
        this.newEntityList = newEntityList;
    }
}
