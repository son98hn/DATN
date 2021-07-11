package com.example.datn.Controller.Admin.API;

import com.example.datn.dto.NewDTO;
import com.example.datn.entity.NewEntity;
import com.example.datn.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class NewAPI {
    @Autowired
    private INewService newService;

    @PostMapping(value = "/api-admin-new", produces = "application/json;charset=UTF-8")
    public NewEntity createNew(@RequestBody NewDTO model, HttpServletRequest request, Principal principal) {
        String userName = principal.getName();
        model.setCreatedBy(userName);
        return newService.save(model);
    }

    @PutMapping(value = "/api-admin-new", produces = "application/json;charset=UTF-8")
    public NewEntity updateNew(@RequestBody NewDTO model, HttpServletRequest request, Principal principal) {
          String userName = principal.getName();
        model.setModifiedBy(userName);
        return newService.save(model);
    }

    @DeleteMapping(value = "/api-admin-new", produces = "application/json;charset=UTF-8")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}
