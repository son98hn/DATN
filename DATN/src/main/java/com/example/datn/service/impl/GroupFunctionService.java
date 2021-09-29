package com.example.datn.service.impl;

import com.example.datn.dto.GroupFunctionDTO;
import com.example.datn.entity.GroupFunctionEntity;
import com.example.datn.repository.FunctionRepository;
import com.example.datn.repository.GroupFunctionRepository;
import com.example.datn.repository.GroupRepository;
import com.example.datn.service.IGroupFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupFunctionService implements IGroupFunctionService {
    private GroupFunctionRepository groupFunctionRepository;
    private GroupRepository groupRepository;
    private FunctionRepository functionRepository;

    public GroupFunctionService(FunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    @Autowired
    public GroupFunctionService(GroupFunctionRepository groupFunctionRepository, GroupRepository groupRepository) {
        this.groupFunctionRepository = groupFunctionRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public void saveGroupFunction(GroupFunctionDTO groupFunctionDTO) {
        GroupFunctionEntity groupFunctionEntity = new GroupFunctionEntity();
        groupFunctionEntity.setGroupEntity(groupRepository.findById(groupFunctionDTO.getGroupId()).get());
        groupFunctionEntity.setFunctionEntity(functionRepository.findById(groupFunctionDTO.getFunctionId()).get());
        groupFunctionRepository.save(groupFunctionEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            groupFunctionRepository.deleteById(item);
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
    public List<GroupFunctionEntity> findAll() {
        return groupFunctionRepository.findAll();
    }

    @Override
    public int totalItem() {
        return (int) groupFunctionRepository.count();
    }

    @Override
    public void deleteGroupFunctionByGroupId(Long groupId) {
        groupFunctionRepository.deleteGroupFunctionByGroupId(groupId);
    }
}
