package com.example.datn.repository;

import com.example.datn.entity.GroupFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GroupFunctionRepository extends JpaRepository<GroupFunctionEntity, Long> {
    @Modifying
    @Query(value = "DELETE FROM group_funtion WHERE group_function.group_id=?1", nativeQuery = true)
    void deleteGroupFunctionByGroupId(Long groupRoleId);

    @Modifying
    @Query(value = "DELETE FROME group_function WHERE group_function.function_id=?1", nativeQuery = true)
    void deleteGroupFunctionByFunctionId(Long roleDetailId);

    //    GroupFunctionEntity findByRoleDetailEntityId(Long roleDetailId);
    GroupFunctionEntity findByFunctionEntityId(Long functionId);
}
