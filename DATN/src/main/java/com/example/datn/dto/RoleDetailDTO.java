package com.example.datn.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDetailDTO extends AbstractDTO<RoleDetailDTO> {


    private String permission;
    private String code;


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

}
