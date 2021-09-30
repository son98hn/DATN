package com.example.datn.Controller.Admin.API;

import com.example.datn.dto.GroupDTO;
import com.example.datn.service.IGroupService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
public class GroupAPI {
    private final IGroupService groupService;

    public GroupAPI(IGroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(value = "/api-admin-group", produces = "application/json;charset=UTF-8")
    public void createGroupRole(@RequestBody GroupDTO model, HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setCreatedBy(userDTO.getUserName());
        groupService.saveGroup(model);
    }

    @PutMapping(value = "/api-admin-group", produces = "application/json;charset=UTF-8")
    public void updateGroupRole(@RequestBody GroupDTO model, HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//        model.setModifiedBy(userDTO.getUserName());
        groupService.saveGroup(model);
    }

    @DeleteMapping(value = "/api-admin-group", produces = "application/json;charset=UTF-8")
    public void deleteGroupRole(@RequestBody long[] ids) {
        groupService.delete(ids);
    }
}
