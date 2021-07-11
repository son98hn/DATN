package com.example.datn.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractDTO<UserDTO> {
    private String userName;
    private String password;
    private List<String> groupRoleName;
//    private List<String> listRoleDetailCode = new ArrayList<>();
//    private List<List> listGroupRoleName = new ArrayList<>();


//    public List<String> getListRoleDetailCode() {
//        return listRoleDetailCode;
//    }
//
//    public void setListRoleDetailCode(List<String> listRoleDetailCode) {
//        this.listRoleDetailCode = listRoleDetailCode;
//    }
//
//    public List<List> getListGroupRoleName() {
//        return listGroupRoleName;
//    }
//
//    public void setListGroupRoleName(List<List> listGroupRoleName) {
//        this.listGroupRoleName = listGroupRoleName;
//    }

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


    public List<String> getGroupRoleName() {
        return groupRoleName;
    }

    public void setGroupRoleName(List<String> groupRoleName) {
        this.groupRoleName = groupRoleName;
    }
}
