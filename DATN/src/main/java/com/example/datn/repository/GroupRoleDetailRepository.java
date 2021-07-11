package com.example.datn.repository;

import com.example.datn.entity.GroupRoleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GroupRoleDetailRepository extends JpaRepository<GroupRoleDetailEntity, Long> {
    @Modifying
   @Query(value = "DELETE FROM grouprole_roledetail WHERE grouprole_roledetail.group_role_id=?1", nativeQuery = true)
    void deleteGroupRoleDetailByGroupRoleId(Long groupRoleId);
    @Modifying
    @Query(value = "DELETE FROME grouprole_roledetail WHERE grouprole_roledetail.roledetailid=?1", nativeQuery = true)
    void deleteGroupRoleDetailByRoleDetailId(Long roleDetailId);
    GroupRoleDetailEntity findByRoleDetailEntityId(Long roleDetailId);
}
