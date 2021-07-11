package com.example.datn.Controller.Admin.API;

import com.example.datn.dto.GroupRoleDTO;
import com.example.datn.entity.GroupRoleEntity;
import com.example.datn.service.IGroupRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
public class GroupRoleAPI {
    @Autowired
    private IGroupRoleService groupRoleService;

    @PostMapping(value = "/api-admin-grouprole", produces = "application/json;charset=UTF-8")
    public GroupRoleEntity createGroupRole(@RequestBody GroupRoleDTO model, HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setCreatedBy(userDTO.getUserName());
        return groupRoleService.save(model);
    }

    @PutMapping(value = "/api-admin-grouprole", produces = "application/json;charset=UTF-8")
    public GroupRoleEntity updateGroupRole(@RequestBody GroupRoleDTO model, HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setModifiedBy(userDTO.getUserName());
        return groupRoleService.save(model);
    }

    @DeleteMapping(value = "/api-admin-grouprole", produces = "application/json;charset=UTF-8")
    public void deleteGroupRole(@RequestBody long[] ids) {
        groupRoleService.delete(ids);
    }
}
