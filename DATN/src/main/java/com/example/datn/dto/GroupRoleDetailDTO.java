package com.example.datn.dto;

public class GroupRoleDetailDTO extends AbstractDTO<GroupRoleDetailDTO>{
    private Long groupRoleId;
    private Long roleDetailId;

    public Long getGroupRoleId() {
        return groupRoleId;
    }

    public void setGroupRoleId(Long groupRoleId) {
        this.groupRoleId = groupRoleId;
    }

    public Long getRoleDetailId() {
        return roleDetailId;
    }

    public void setRoleDetailId(Long roleDetailId) {
        this.roleDetailId = roleDetailId;
    }
}
