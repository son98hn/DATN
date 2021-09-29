package com.example.datn.service;

import com.example.datn.dto.GroupDTO;
import com.example.datn.entity.GroupEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupService {
    void saveGroup(GroupDTO groupDTO);

    void delete(long[] ids);

    List<GroupEntity> findAll();

    int totalItem();

    List<GroupEntity> findGroupByUserName(String userName);

    GroupEntity findById(Long id);

    List<GroupEntity> findGroup(Pageable pageable);
}
