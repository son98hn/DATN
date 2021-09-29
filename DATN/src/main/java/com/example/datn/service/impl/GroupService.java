package com.example.datn.service.impl;

import com.example.datn.dto.GroupDTO;
import com.example.datn.entity.GroupEntity;
import com.example.datn.entity.GroupFunctionEntity;
import com.example.datn.repository.FunctionRepository;
import com.example.datn.repository.GroupFunctionRepository;
import com.example.datn.repository.GroupRepository;
import com.example.datn.service.IGroupService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    private final
    GroupFunctionRepository groupFunctionRepository;
    private final
    FunctionRepository functionRepository;
    private final
    GroupRepository groupRepository;

    public GroupService(FunctionRepository functionRepository, GroupFunctionRepository groupFunctionRepository, GroupRepository groupRepository) {
        this.functionRepository = functionRepository;
        this.groupFunctionRepository = groupFunctionRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public void saveGroup(GroupDTO groupDTO) {
        if (groupDTO.getId() != null) {
            groupFunctionRepository.deleteGroupFunctionByGroupId(groupDTO.getId());
            GroupEntity oldGroupEntity = groupRepository.findById(groupDTO.getId()).get();
            oldGroupEntity.setCode(groupDTO.getCode());
            oldGroupEntity.setName(groupDTO.getName());
            groupRepository.save(oldGroupEntity);
            for (int i = 0; i < groupDTO.getListStringFunctionName().size(); i++) {
                GroupFunctionEntity groupFunctionEntity = new GroupFunctionEntity();
                groupFunctionEntity.setGroupEntity(oldGroupEntity);
                groupFunctionEntity.setFunctionEntity(functionRepository.findByName(groupDTO.getListStringFunctionName().get(i)));
                groupFunctionRepository.save(groupFunctionEntity);
            }
            groupDTO.setMessage("Cập nhật nhóm thành công");
        } else {
            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setName(groupDTO.getName());
            groupEntity.setCode(groupDTO.getCode());
            groupRepository.save(groupEntity);
            for (int i = 0; i < groupDTO.getListStringFunctionName().size(); i++) {
                GroupFunctionEntity groupFunctionEntity = new GroupFunctionEntity();
                groupFunctionEntity.setGroupEntity(groupEntity);
                groupFunctionEntity.setFunctionEntity(functionRepository.findByName(groupDTO.getListStringFunctionName().get(i)));
                groupFunctionRepository.save(groupFunctionEntity);
            }
        }

    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            GroupEntity groupEntity = groupRepository.findById(item).get();
            groupFunctionRepository.deleteGroupFunctionByGroupId(groupEntity.getId());
            groupRepository.deleteById(item);
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
    public List<GroupEntity> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public int totalItem() {
        return (int) groupRepository.count();
    }

    @Override
    public List<GroupEntity> findGroupByUserName(String userName) {
        return groupRepository.findGroupByUserName(userName);
    }

    @Override
    public GroupEntity findById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public List<GroupEntity> findGroup(Pageable pageable) {
        return groupRepository.findGroup(pageable);
    }
}
