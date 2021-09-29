package com.example.datn.repository;

import com.example.datn.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long> {
//    @Modifying
//    @Query(value = "DELETE FROM [group_user] WHERE [group_user].[user_id]=?1", nativeQuery = true)
    void deleteByUserEntityId(Long userId);

//    void deleteByUserEntityId(long userid);

    UserGroupEntity findByUserEntityId(Long id);
}
