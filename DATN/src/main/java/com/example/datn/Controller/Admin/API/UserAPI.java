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
    private final IUserService userService;

    public UserAPI(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/api-admin-user", produces = "application/json;charset=UTF-8")
    public void createUser(@RequestBody UserDTO model, HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setCreatedBy(userDTO.getUserName());
        userService.saveUser(model);
    }

    @PutMapping(path = "/api-admin-user", produces = "application/json;charset=UTF-8")
    public void updateUser(@RequestBody UserDTO userDTO) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setModifiedBy(userDTO.getUserName());
        userService.saveUser(userDTO);
    }


    @DeleteMapping(value = "/api-admin-user", produces = "application/json;charset=UTF-8")
    public void deleteUser(@RequestBody long[] ids) {
        userService.delete(ids);
    }

    @PutMapping(value = "api-admin-resetuser")
    public void resetPassword(@RequestBody long[] ids) {
        userService.resetPassword(ids);
    }
}
