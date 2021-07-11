package com.example.datn.service.impl;

import com.example.datn.dto.GroupRoleUserDTO;
import com.example.datn.entity.GroupRoleEntity;
import com.example.datn.entity.GroupRoleUserEntity;
import com.example.datn.entity.UserEntity;
import com.example.datn.repository.GroupRoleRepository;
import com.example.datn.repository.GroupRoleUserRepository;
import com.example.datn.repository.UserRepository;
import com.example.datn.service.IGroupRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupRoleUserService implements IGroupRoleUserService {

    @Autowired
    private GroupRoleUserRepository groupRoleUserRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRoleRepository groupRoleRepository;

    @Override
    public GroupRoleUserEntity save(GroupRoleUserDTO groupRoleUserDTO) {
        GroupRoleEntity groupRoleEntity = groupRoleRepository.findById(groupRoleUserDTO.getGroupRoleId()).get();
        UserEntity userEntity = userRepository.findById(groupRoleUserDTO.getUserId()).get();
        if(groupRoleUserDTO.getId()!=null) {
           GroupRoleUserEntity oldGroupRoleUserEntity = groupRoleUserRepository.findById(groupRoleUserDTO.getId()).get();
          oldGroupRoleUserEntity.setGroupRoleEntity(groupRoleEntity);
           oldGroupRoleUserEntity.setUserEntity(userEntity);
           groupRoleUserRepository.save(oldGroupRoleUserEntity);
           return groupRoleUserRepository.findById(oldGroupRoleUserEntity.getId()).get();
       }else {
           GroupRoleUserEntity groupRoleUserEntity = new GroupRoleUserEntity();
           groupRoleUserEntity.setUserEntity(userEntity);
           groupRoleUserEntity.setGroupRoleEntity(groupRoleEntity);
           groupRoleUserRepository.save(groupRoleUserEntity);
           return groupRoleUserRepository.findById(groupRoleEntity.getId()).get();
       }
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            groupRoleUserRepository.deleteById(item);
        }
    }

//    @Override
//    public List<GroupRoleUserDTO> findAll(Pageable pageable) {
//        List<GroupRoleUserDTO> results = new ArrayList<>();
//        List<GroupRoleUserEntity> entities = groupRoleUserRepository.findAll(pageable).getContent();
//        for (GroupRoleUserEntity item : entities) {
//            GroupRoleUserDTO groupRoleUserDTO = new GroupRoleUserDTO();
//            groupRoleUserDTO.setUserId(item.getUserEntity().getId());
//            groupRoleUserDTO.setGroupRoleId(item.getGroupRoleEntity().getId());
//
//        }
//        return results;
//    }

    @Override
    public List<GroupRoleUserEntity> findAll() {
        return groupRoleUserRepository.findAll();
    }

    @Override
    public int totalItem() {
        return (int) groupRoleUserRepository.count();
    }
}
