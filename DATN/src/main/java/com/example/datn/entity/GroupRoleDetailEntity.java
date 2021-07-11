package com.example.datn.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grouprole_roledetail")
public class GroupRoleDetailEntity extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "group_role_id")
    private GroupRoleEntity groupRoleEntity;

    @ManyToOne
    @JoinColumn(name = "roledetailid")
    private RoleDetailEntity roleDetailEntity;

    public GroupRoleEntity getGroupRoleEntity() {
        return groupRoleEntity;
    }

    public void setGroupRoleEntity(GroupRoleEntity groupRoleEntity) {
        this.groupRoleEntity = groupRoleEntity;
    }

    public RoleDetailEntity getRoleDetailEntity() {
        return roleDetailEntity;
    }

    public void setRoleDetailEntity(RoleDetailEntity roleDetailEntity) {
        this.roleDetailEntity = roleDetailEntity;
    }
}
