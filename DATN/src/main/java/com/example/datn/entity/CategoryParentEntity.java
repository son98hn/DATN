package com.example.datn.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoryparent")
public class CategoryParentEntity extends BaseEntity {

    private String code;
    private String name;

//    @OneToMany(mappedBy = "categoryParentEntity")
//    private List<CategoryEntity> categoryEntities = new ArrayList<>();

    @OneToMany(mappedBy = "categoryParentEntity")
    private List<CategoryEntity> categoryEntities = new ArrayList<>();

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

    public List<CategoryEntity> getCategoryEntities() {
        return categoryEntities;
    }

    public void setCategoryEntities(List<CategoryEntity> categoryEntities) {
        this.categoryEntities = categoryEntities;
    }
}
