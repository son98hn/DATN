package com.example.datn.Controller.Admin.API;

import com.example.datn.dto.NewDTO;
import com.example.datn.entity.NewEntity;
import com.example.datn.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class NewAPI {
    private final INewService newService;

    public NewAPI(INewService newService) {
        this.newService = newService;
    }

    @PostMapping(value = "/api-admin-new", produces = "application/json;charset=UTF-8")
    public void createNew(@RequestBody NewDTO model, HttpServletRequest request, Principal principal) {
        String userName = principal.getName();
        model.setCreatedBy(userName);
        newService.saveNew(model);
    }

    @PutMapping(value = "/api-admin-new", produces = "application/json;charset=UTF-8")
    public void updateNew(@RequestBody NewDTO model, HttpServletRequest request, Principal principal) {
          String userName = principal.getName();
        model.setModifiedBy(userName);
        newService.saveNew(model);
    }

    @PutMapping(value = "/api-admin-activeNew/{id}")
    public void activeNew(@PathVariable Long id) {
        newService.activeNew(id);
    }

    @DeleteMapping(value = "/api-admin-new", produces = "application/json;charset=UTF-8")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}
