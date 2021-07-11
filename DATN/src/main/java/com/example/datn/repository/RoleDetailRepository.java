package com.example.datn.repository;

import com.example.datn.entity.NewEntity;
import com.example.datn.entity.RoleDetailEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoleDetailRepository extends JpaRepository<RoleDetailEntity, Long> {
    RoleDetailEntity findOneByPermission(String roleDetail_str);
    @Query(value = "select * from roledetail inner join grouprole_roledetail on roledetail.id = grouprole_roledetail.roledetailid INNER JOIN group_role on group_role.id = grouprole_roledetail.group_role_id where [group_role].id = ?1", nativeQuery = true)
    List<RoleDetailEntity> findRoleByGroupRoleId(Long id_long);
//    @Query(value = "select * from roledetail inner join role on roledetail.roleid = role.id where role.id = ?1", nativeQuery = true)
//    List<RoleDetailEntity> findRoleByRoleId(Long id_long);
    @Query(value = "select * from roledetail inner join grouprole_roledetail on roledetail.id = grouprole_roledetail.roledetailid INNER JOIN group_role on group_role.id = grouprole_roledetail.group_role_id inner join grouprole_user on group_role.id = grouprole_user.group_roleid inner join users on grouprole_user.userid = users.id where users.username = ?1", nativeQuery = true)
    List<RoleDetailEntity> findRoleByUserName(String userName);
    @Query(value = "SELECT * FROM [roledetail]",nativeQuery = true)
    List<RoleDetailEntity> findRoleDetail(Pageable pageable);
}
