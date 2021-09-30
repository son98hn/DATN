package com.example.datn.Controller.Admin.API;

import com.example.datn.dto.FunctionDTO;
import com.example.datn.service.IFunctionService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
public class FunctionAPI {
    private final IFunctionService functionService;

    public FunctionAPI(IFunctionService functionService) {
        this.functionService = functionService;
    }

    @PostMapping(value = "/api-admin-function", produces = "application/json;charset=UTF-8")
    public void createFunction(@RequestBody FunctionDTO model, HttpServletRequest request) {
        functionService.saveFunction(model);
    }

    @PutMapping(value = "/api-admin-function", produces = "application/json;charset=UTF-8")
    public void updateRoleDetail(@RequestBody FunctionDTO model, HttpServletRequest request) {
        functionService.saveFunction(model);
    }

    @DeleteMapping(value = "/api-admin-function", produces = "application/json;charset=UTF-8")
    public void deleteRoleDetail(@RequestBody long[] ids) {
        functionService.delete(ids);
    }
}
