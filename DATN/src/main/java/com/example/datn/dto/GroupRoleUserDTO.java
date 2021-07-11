package com.example.datn.dto;

public class GroupRoleUserDTO extends AbstractDTO<GroupRoleUserDTO>{

    private Long groupRoleId;
    private Long userId;

    public Long getGroupRoleId() {
        return groupRoleId;
    }

    public void setGroupRoleId(Long groupRoleId) {
        this.groupRoleId = groupRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
