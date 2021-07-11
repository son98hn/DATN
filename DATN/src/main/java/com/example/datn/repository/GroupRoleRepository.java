package com.example.datn.repository;

import com.example.datn.entity.GroupRoleEntity;
import com.example.datn.entity.NewEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface GroupRoleRepository extends JpaRepository<GroupRoleEntity, Long> {
    @Query(value = "SELECT * FROM group_role INNER JOIN grouprole_user ON grouprole_user.group_roleid=group_role.id INNER JOIN users on grouprole_user.userid = users.id WHERE users.username =?1", nativeQuery = true)
    List<GroupRoleEntity> findGroupRoleByUserName(String userName);
    GroupRoleEntity findByName(String name);
    @Query(value = "SELECT * FROM [group_role]",nativeQuery = true)
    List<GroupRoleEntity> findGroupRole(Pageable pageable);
}
