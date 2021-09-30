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
    void deleteByUserEntityId(Long userId);

    UserGroupEntity findByUserEntityId(Long id);
}
