package com.example.datn.service.impl;

import com.example.datn.dto.GroupRoleDetailDTO;
import com.example.datn.entity.GroupRoleDetailEntity;
import com.example.datn.repository.GroupRoleDetailRepository;
import com.example.datn.repository.GroupRoleRepository;
import com.example.datn.repository.RoleDetailRepository;
import com.example.datn.service.IGroupRoleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupRoleDetailService implements IGroupRoleDetailService {
    @Autowired
    private GroupRoleDetailRepository groupRoleDetailRepository;
    @Autowired
    private GroupRoleRepository groupRoleRepository;
    @Autowired
    private RoleDetailRepository roleDetailRepository;

    @Override
    public GroupRoleDetailEntity save(GroupRoleDetailDTO groupRoleDetailDTO) {
        GroupRoleDetailEntity groupRoleDetailEntity = new GroupRoleDetailEntity();
        groupRoleDetailEntity.setGroupRoleEntity(groupRoleRepository.findById(groupRoleDetailDTO.getGroupRoleId()).get());
        groupRoleDetailEntity.setRoleDetailEntity(roleDetailRepository.findById(groupRoleDetailDTO.getRoleDetailId()).get());
        return groupRoleDetailRepository.save(groupRoleDetailEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            groupRoleDetailRepository.deleteById(item);
        }
    }

//    @Override
//    public List<GroupRoleDetailEntity> findAll(Pageable pageable) {
//        List<GroupRoleDetailDTO> results = new ArrayList<>();
//        List<GroupRoleDetailEntity> entities = groupRoleDetailRepository.findAll(pageable).getContent();
//        for (GroupRoleDetailEntity item : entities) {
//            GroupRoleDetailDTO groupRoleDetailDTO = new GroupRoleDetailDTO();
//            groupRoleDetailDTO.setRoleDetailId(item.getRoleDetailEntity().getId());
//            groupRoleDetailDTO.setGroupRoleId(item.getGroupRoleEntity().getId());
//        }
//        return results;
//    }

    @Override
    public List<GroupRoleDetailEntity> findAll() {
        return groupRoleDetailRepository.findAll();
    }

    @Override
    public int totalItem() {
        return (int) groupRoleDetailRepository.count();
    }

    @Override
    public void deleteGroupRoleDetailByGroupRoleId(Long groupRoleId) {
        groupRoleDetailRepository.deleteGroupRoleDetailByGroupRoleId(groupRoleId);
    }
}
