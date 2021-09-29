package com.example.datn.repository;

import com.example.datn.entity.GroupEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    @Query(value = "SELECT * FROM [group] INNER JOIN user_group ON user_group.group_id=[group].id INNER JOIN [user] on user_group.user_id = [user].id WHERE [user].username =?1", nativeQuery = true)
    List<GroupEntity> findGroupByUserName(String userName);
    GroupEntity findByName(String name);
    @Query(value = "SELECT * FROM [group]",nativeQuery = true)
    List<GroupEntity> findGroup(Pageable pageable);
}
