package com.example.datn.repository;

import com.example.datn.entity.GroupRoleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface GroupRoleUserRepository extends JpaRepository<GroupRoleUserEntity, Long> {
    @Modifying
    @Query(value = "DELETE FROM [grouprole_user] WHERE [grouprole_user].[userid]=?1", nativeQuery = true)
    void deleteByUserId(Long userid);
    void deleteByUserEntityId(long userid);
    GroupRoleUserEntity findOneByUserEntityId(Long id);

}
