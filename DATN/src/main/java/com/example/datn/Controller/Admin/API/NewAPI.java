package com.example.datn.Controller.Admin.API;

import com.example.datn.dto.NewDTO;
import com.example.datn.entity.NewEntity;
import com.example.datn.repository.NewRepository;
import com.example.datn.service.INewService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class NewAPI {
    private final INewService newService;

    private final NewRepository newRepository;

    public NewAPI(INewService newService, NewRepository newRepository) {
        this.newService = newService;
        this.newRepository = newRepository;
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

    @PutMapping(value = "/api-admin-activeNew")
    public void activeNew(@RequestBody long[] ids, Principal principal) {
        String username = principal.getName();
        for (long id : ids) {
            NewEntity newEntity = newService.findById(id);
            newEntity.setModifiedBy(username);
            newEntity.setStatus(1);
            newEntity.setModifiedDate(LocalDateTime.now());
            newRepository.save(newEntity);
        }
    }

    @DeleteMapping(value = "/api-admin-new", produces = "application/json;charset=UTF-8")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}
