package com.example.datn.service.impl;

import com.example.datn.dto.GroupRoleDTO;
import com.example.datn.entity.GroupRoleDetailEntity;
import com.example.datn.entity.GroupRoleEntity;
import com.example.datn.repository.GroupRoleDetailRepository;
import com.example.datn.repository.GroupRoleRepository;
import com.example.datn.repository.RoleDetailRepository;
import com.example.datn.service.IGroupRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupRoleService implements IGroupRoleService {
    @Autowired
    GroupRoleDetailRepository groupRoleDetailRepository;
    @Autowired
    RoleDetailRepository roleDetailRepository;
    @Autowired
    GroupRoleRepository groupRoleRepository;

    @Override
    public GroupRoleEntity save(GroupRoleDTO groupRoleDTO) {
        if (groupRoleDTO.getId() != null) {
            groupRoleDetailRepository.deleteGroupRoleDetailByGroupRoleId(groupRoleDTO.getId());
            GroupRoleEntity oldGroupRoleEntity = groupRoleRepository.findById(groupRoleDTO.getId()).get();
            return getGroupRoleEntity(groupRoleDTO, oldGroupRoleEntity);
        } else {
            GroupRoleEntity groupRoleEntity = new GroupRoleEntity();
            return getGroupRoleEntity(groupRoleDTO, groupRoleEntity);
        }

    }

    private GroupRoleEntity getGroupRoleEntity(GroupRoleDTO groupRoleDTO, GroupRoleEntity groupRoleEntity) {
        groupRoleEntity.setCode(groupRoleDTO.getCode());
        groupRoleEntity.setName(groupRoleDTO.getName());
        groupRoleRepository.save(groupRoleEntity);
        for (int i = 0; i < groupRoleDTO.getListStringRoleDetailName().size(); i++) {
            GroupRoleDetailEntity groupRoleDetailEntity = new GroupRoleDetailEntity();
            groupRoleDetailEntity.setGroupRoleEntity(groupRoleEntity);
            groupRoleDetailEntity.setRoleDetailEntity(roleDetailRepository.findOneByPermission(groupRoleDTO.getListStringRoleDetailName().get(i)));
            groupRoleDetailRepository.save(groupRoleDetailEntity);
        }
        groupRoleRepository.save(groupRoleEntity);
        return groupRoleRepository.findById(groupRoleEntity.getId()).get();
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            GroupRoleEntity groupRoleEntity = groupRoleRepository.findById(item).get();
            groupRoleDetailRepository.deleteGroupRoleDetailByGroupRoleId(groupRoleEntity.getId());
            groupRoleRepository.deleteById(item);
        }
    }

//    @Override
//    public List<GroupRoleEntity> findAll(Pageable pageable) {
//        List<GroupRoleDTO> results = new ArrayList<>();
//        List<GroupRoleEntity> entities = groupRoleRepository.findAll(pageable).getContent();
//        for (GroupRoleEntity item : entities) {
//            GroupRoleDTO groupRoleDTO = new GroupRoleDTO();
//            groupRoleDTO.setName(item.getName());
//            groupRoleDTO.setCode(item.getCode());
//            results.add(groupRoleDTO);
//        }
//        return results;
//    }

    @Override
    public List<GroupRoleEntity> findAll() {
        return groupRoleRepository.findAll();
    }

    @Override
    public int totalItem() {
        return (int) groupRoleRepository.count();
    }

    @Override
    public List<GroupRoleEntity> findGroupRoleByUserName(String userName) {
        return groupRoleRepository.findGroupRoleByUserName(userName);
    }

    @Override
    public GroupRoleEntity findById(Long id) {
        return groupRoleRepository.findById(id).get();
    }

    @Override
    public List<GroupRoleEntity> findGroupRole(Pageable pageable) {
        return groupRoleRepository.findGroupRole(pageable);
    }


}
