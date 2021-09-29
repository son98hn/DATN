package com.example.datn.dto;

import java.util.ArrayList;
import java.util.List;

public class GroupDTO extends AbstractDTO<GroupDTO>{
    private String code;
    private String name;
    private List<String> listStringFunctionName = new ArrayList<>();

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

    public List<String> getListStringFunctionName() {
        return listStringFunctionName;
    }

    public void setListStringFunctionName(List<String> listStringFunctionName) {
        this.listStringFunctionName = listStringFunctionName;
    }
}
