package com.example.datn.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category_parent")
public class CategoryParentEntity extends BaseEntity {
    private String code;

    private String name;

    @OneToMany(mappedBy = "categoryParentEntity")
    private List<CategoryEntity> categoryEntityList = new ArrayList<>();

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

    public List<CategoryEntity> getCategoryEntityList() {
        return categoryEntityList;
    }

    public void setCategoryEntityList(List<CategoryEntity> categoryEntities) {
        this.categoryEntityList = categoryEntityList;
    }
}
