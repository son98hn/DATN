package com.example.datn.service.impl;


import com.example.datn.dto.FunctionDTO;
import com.example.datn.entity.FunctionEntity;
import com.example.datn.entity.GroupFunctionEntity;
import com.example.datn.repository.FunctionRepository;
import com.example.datn.repository.GroupFunctionRepository;
import com.example.datn.service.IFunctionService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionService implements IFunctionService {
    public FunctionService(FunctionRepository functionRepository, GroupFunctionRepository groupFunctionRepository) {
        this.functionRepository = functionRepository;
        this.groupFunctionRepository = groupFunctionRepository;
    }

    private final FunctionRepository functionRepository;


    private final GroupFunctionRepository groupFunctionRepository;

    @Override
    public void saveFunction(FunctionDTO functionDTO) {
        if (functionDTO.getId() == null) {
            if (!verifyFunction(functionDTO.getName(), functionDTO.getCode())) {
                FunctionEntity functionEntity = new FunctionEntity();
                functionEntity.setCode(functionDTO.getCode());
                functionEntity.setName(functionDTO.getName());
                functionRepository.save(functionEntity);
                functionDTO.setMessage("Tạo quyền thành công");
            } else {
                functionDTO.setMessage("Quyền đã tồn tại");
            }
        } else {
            if(!verifyFunction(functionDTO.getName(), functionDTO.getCode())) {
//                FunctionEntity functionEntity = new FunctionEntity();
                FunctionEntity oldFunctionEntity = functionRepository.findById(functionDTO.getId()).get();
                oldFunctionEntity.setCode(functionDTO.getCode());
                oldFunctionEntity.setName(functionDTO.getName());
                functionRepository.save(oldFunctionEntity);
                functionDTO.setMessage("Cập nhật quyền thành công");
            } else {
                functionDTO.setMessage("Cập nhật quyền thất bại");
            }
        }
    }

    private Boolean verifyFunction(String name, String code) {
        return (functionRepository.existsByNameOrCode(name, code));
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
//            groupRoleDetailRepository.deleteGroupRoleDetailByRoleDetailId(item);
            GroupFunctionEntity groupFunctionEntity = groupFunctionRepository.findByFunctionEntityId(item);
            if (groupFunctionEntity != null) {
                groupFunctionRepository.deleteById(groupFunctionEntity.getId());
            }
            functionRepository.deleteById(item);
        }
    }

//    @Override
//    public List<RoleDetailEntity> findAll(Pageable pageable) {
//        List<RoleDetailDTO> results = new ArrayList<>();
//        List<RoleDetailEntity> entities = roleDetailRepository.findAll(pageable).getContent();
//        for (RoleDetailEntity item : entities) {
//            RoleDetailDTO roleDetailDTO = new RoleDetailDTO();
//            roleDetailDTO.setRoleId(item.getRoleEntity().getId());
//            roleDetailDTO.setPermission(item.getPermission());
//            roleDetailDTO.setCode(item.getCode());
//        }
//        return results;
//    }

    @Override
    public List<FunctionEntity> findAll() {
        return functionRepository.findAll();
    }

    @Override
    public int totalItem() {
        return (int) functionRepository.count();
    }

    @Override
    public List<FunctionEntity> findRoleByUserName(String userName) {
        return functionRepository.findRoleByUserName(userName);
    }

    @Override
    public List<FunctionEntity> findRoleByGroupRoleId(Long id_long) {
        return functionRepository.findRoleByGroupId(id_long);
    }

//    @Override
//    public List<RoleDetailEntity> findRoleByRoleId(Long id_long) {
//        return roleDetailRepository.findRoleByRoleId(id_long);
//    }

    @Override
    public FunctionEntity findById(Long id) {
        return functionRepository.findById(id).get();
    }

    @Override
    public List<FunctionEntity> findRoleDetail(Pageable pageable) {
        return functionRepository.findFuntion(pageable);
    }
}
