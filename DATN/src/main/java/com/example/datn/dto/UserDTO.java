package com.example.datn.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractDTO<UserDTO> {
    private String userName;
    private String password;
    private List<String> groupName;
    //    private Integer status;
    private String email;
    private String phone;
    private String name;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone
    ) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.phone = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name
    ) {
        this.name = name;
    }

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


    public List<String> getGroupName() {
        return groupName;
    }

    public void setGroupName(List<String> groupName) {
        this.groupName = groupName;
    }
}
