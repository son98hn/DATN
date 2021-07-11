package com.example.datn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "userEntity")
    private List<GroupRoleUserEntity> groupRoleUserEntityList = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GroupRoleUserEntity> getGroupRoleUserEntityList() {
        return groupRoleUserEntityList;
    }

    public void setGroupRoleUserEntityList(List<GroupRoleUserEntity> groupRoleUserEntityList) {
        this.groupRoleUserEntityList = groupRoleUserEntityList;
    }
}
