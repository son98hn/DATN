package com.example.datn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groupss")
public class GroupEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "groupEntity")
    private List<GroupFunctionEntity> groupFunctionEntityList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<GroupFunctionEntity> getGroupFunctionEntityList() {
        return groupFunctionEntityList;
    }

    public void setGroupFunctions(List<GroupFunctionEntity> groupFunctionEntityList) {
        this.groupFunctionEntityList = groupFunctionEntityList;
    }
}
