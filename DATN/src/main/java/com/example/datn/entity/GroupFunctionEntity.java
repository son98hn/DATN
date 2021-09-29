package com.example.datn.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_function")
public class GroupFunctionEntity extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity groupEntity;

    @ManyToOne
    @JoinColumn(name = "function_id")
    private FunctionEntity functionEntity;

    public GroupEntity getGroupEntity() {
        return groupEntity;
    }

    public void setGroupEntity(GroupEntity groupEntity) {
        this.groupEntity = groupEntity;
    }

    public FunctionEntity getFunctionEntity() {
        return functionEntity;
    }

    public void setFunctionEntity(FunctionEntity functionEntity) {
        this.functionEntity = functionEntity;
    }
}
