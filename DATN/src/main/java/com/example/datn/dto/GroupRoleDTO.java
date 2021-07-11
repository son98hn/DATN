package com.example.datn.dto;

import java.util.ArrayList;
import java.util.List;

public class GroupRoleDTO extends AbstractDTO<GroupRoleDTO>{
    private String code;
    private String name;
    private List<String> listStringRoleDetailName = new ArrayList<>();

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

    public List<String> getListStringRoleDetailName() {
        return listStringRoleDetailName;
    }

    public void setListStringRoleDetailName(List<String> listStringRoleDetailName) {
        this.listStringRoleDetailName = listStringRoleDetailName;
    }
}
