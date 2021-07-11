package com.example.datn.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grouprole_user")
public class GroupRoleUserEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "group_roleid")
    private GroupRoleEntity groupRoleEntity;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;

    public GroupRoleEntity getGroupRoleEntity() {
        return groupRoleEntity;
    }

    public void setGroupRoleEntity(GroupRoleEntity groupRoleEntity) {
        this.groupRoleEntity = groupRoleEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
