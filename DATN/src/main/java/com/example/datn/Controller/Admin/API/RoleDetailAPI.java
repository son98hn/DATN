package com.example.datn.Controller.Admin.API;

import com.example.datn.dto.RoleDetailDTO;
import com.example.datn.entity.RoleDetailEntity;
import com.example.datn.service.IRoleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
public class RoleDetailAPI {
    @Autowired
    private IRoleDetailService roleDetailService;

    @PostMapping(value = "/api-admin-roledetail", produces = "application/json;charset=UTF-8")
    public RoleDetailEntity createRoleDetail(@RequestBody RoleDetailDTO model, HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setCreatedBy(userDTO.getUserName());
        return roleDetailService.save(model);
    }

    @PutMapping(value = "/api-admin-roledetail", produces = "application/json;charset=UTF-8")
    public RoleDetailEntity updateRoleDetail(@RequestBody RoleDetailDTO model, HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setModifiedBy(userDTO.getUserName());
        return roleDetailService.save(model);
    }

    @DeleteMapping(value = "/api-admin-roledetail", produces = "application/json;charset=UTF-8")
    public void deleteRoleDetail(@RequestBody long[] ids) {
        roleDetailService.delete(ids);
    }
}
