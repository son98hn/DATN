package com.example.datn.service.impl;


import com.example.datn.dto.RoleDetailDTO;
import com.example.datn.entity.GroupRoleDetailEntity;
import com.example.datn.entity.RoleDetailEntity;
import com.example.datn.repository.GroupRoleDetailRepository;
import com.example.datn.repository.RoleDetailRepository;
import com.example.datn.service.IRoleDetailService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.acl.Group;
import java.util.List;

@Service
public class RoleDetailService implements IRoleDetailService {
    public RoleDetailService(RoleDetailRepository roleDetailRepository, GroupRoleDetailRepository groupRoleDetailRepository) {
        this.roleDetailRepository = roleDetailRepository;
        this.groupRoleDetailRepository = groupRoleDetailRepository;
    }

    private final RoleDetailRepository roleDetailRepository;


    private final GroupRoleDetailRepository groupRoleDetailRepository;

    @Override
    public RoleDetailEntity save(RoleDetailDTO roleDetailDTO) {
        if(roleDetailDTO.getId()!=null) {
            RoleDetailEntity oldRoleDetailEntity = roleDetailRepository.findById(roleDetailDTO.getId()).get();
            oldRoleDetailEntity.setCode(roleDetailDTO.getCode());
            oldRoleDetailEntity.setPermission(roleDetailDTO.getPermission());
            roleDetailRepository.save(oldRoleDetailEntity);
            return roleDetailRepository.findById(oldRoleDetailEntity.getId()).get();
        } else {
            RoleDetailEntity roleDetailEntity = new RoleDetailEntity();
            roleDetailEntity.setPermission(roleDetailDTO.getPermission());
            roleDetailEntity.setCode(roleDetailDTO.getCode());
            roleDetailRepository.save(roleDetailEntity);
            return roleDetailRepository.findById(roleDetailEntity.getId()).get();
        }
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
//            groupRoleDetailRepository.deleteGroupRoleDetailByRoleDetailId(item);
            GroupRoleDetailEntity groupRoleDetailEntity = groupRoleDetailRepository.findByRoleDetailEntityId(item);
            if(groupRoleDetailEntity!=null)
            {
                groupRoleDetailRepository.deleteById(groupRoleDetailEntity.getId());
            }
            roleDetailRepository.deleteById(item);
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
    public List<RoleDetailEntity> findAll() {
        return roleDetailRepository.findAll();
    }

    @Override
    public int totalItem() {
        return (int) roleDetailRepository.count();
    }

    @Override
    public List<RoleDetailEntity> findRoleByUserName(String userName) {
        return  roleDetailRepository.findRoleByUserName(userName);
    }

    @Override
    public List<RoleDetailEntity> findRoleByGroupRoleId(Long id_long) {
        return roleDetailRepository.findRoleByGroupRoleId(id_long);
    }

//    @Override
//    public List<RoleDetailEntity> findRoleByRoleId(Long id_long) {
//        return roleDetailRepository.findRoleByRoleId(id_long);
//    }

    @Override
    public RoleDetailEntity findById(Long id) {
        return roleDetailRepository.findById(id).get();
    }

    @Override
    public List<RoleDetailEntity> findRoleDetail(Pageable pageable) {
        return roleDetailRepository.findRoleDetail(pageable);
    }
}
