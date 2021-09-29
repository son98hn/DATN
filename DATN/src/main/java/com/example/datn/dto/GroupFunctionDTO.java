package com.example.datn.dto;

public class GroupFunctionDTO extends AbstractDTO<GroupFunctionDTO>{
    private Long groupId;
    private Long functionId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }
}
