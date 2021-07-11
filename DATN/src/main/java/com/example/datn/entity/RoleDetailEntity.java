package com.example.datn.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roledetail")
public class RoleDetailEntity extends BaseEntity{
    @Column(name = "permission")
    private String permission;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "roleDetailEntity")
    private List<GroupRoleDetailEntity> groupRoleDetailEntityList = new ArrayList<>();

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<GroupRoleDetailEntity> getGroupRoleDetailEntityList() {
        return groupRoleDetailEntityList;
    }

    public void setGroupRoleDetailEntityList(List<GroupRoleDetailEntity> groupRoleDetailEntityList) {
        this.groupRoleDetailEntityList = groupRoleDetailEntityList;
    }
}
