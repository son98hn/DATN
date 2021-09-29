package com.example.datn.service.impl;

import com.example.datn.dto.UserGroupDTO;
import com.example.datn.entity.GroupEntity;
import com.example.datn.entity.UserEntity;
import com.example.datn.entity.UserGroupEntity;
import com.example.datn.repository.GroupRepository;
import com.example.datn.repository.UserGroupRepository;
import com.example.datn.repository.UserRepository;
import com.example.datn.service.IUserGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService implements IUserGroupService {

    private final UserGroupRepository userGroupRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public UserGroupService(UserGroupRepository userGroupRepository, UserRepository userRepository, GroupRepository groupRepository) {
        this.userGroupRepository = userGroupRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public void saveUserGroup(UserGroupDTO userGroupDTO) {
        GroupEntity groupEntity = groupRepository.findById(userGroupDTO.getGroupId()).get();
        UserEntity userEntity = userRepository.findById(userGroupDTO.getUserId()).get();
        if(userGroupDTO.getId()!=null) {
           UserGroupEntity oldUserGroupEntity = userGroupRepository.findById(userGroupDTO.getId()).get();
            oldUserGroupEntity.setGroupEntity(groupEntity);
            oldUserGroupEntity.setUserEntity(userEntity);
            userGroupRepository.save(oldUserGroupEntity);
       }else {
           UserGroupEntity userGroupEntity = new UserGroupEntity();
            userGroupEntity.setUserEntity(userEntity);
            userGroupEntity.setGroupEntity(groupEntity);
           userGroupRepository.save(userGroupEntity);
       }
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            userGroupRepository.deleteById(item);
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
    public List<UserGroupEntity> findAll() {
        return userGroupRepository.findAll();
    }

    @Override
    public int totalItem() {
        return (int) userGroupRepository.count();
    }
}
