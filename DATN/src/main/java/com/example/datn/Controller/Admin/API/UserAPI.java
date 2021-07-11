package com.example.datn.Controller.Admin.API;

import com.example.datn.dto.UserDTO;
import com.example.datn.entity.UserEntity;
import com.example.datn.service.IUserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserAPI {
    @Autowired
    private IUserService userService;

    @PostMapping(value = "/api-admin-user", produces = "application/json;charset=UTF-8")
    public UserEntity createUser(@RequestBody UserDTO model, HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setCreatedBy(userDTO.getUserName());
        return userService.save(model);
    }

    @PutMapping(path = "/api-admin-user", produces = "application/json;charset=UTF-8")
    public  UserEntity updateUser(@RequestBody UserDTO dto , HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setModifiedBy(userDTO.getUserName());
        return userService.save(dto);
    }


    @DeleteMapping(value = "/api-admin-user", produces = "application/json;charset=UTF-8")
    public void deleteUser(@RequestBody long[] ids) {
        userService.delete(ids);
    }
}
