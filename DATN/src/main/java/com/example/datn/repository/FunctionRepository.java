package com.example.datn.repository;

import com.example.datn.entity.FunctionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FunctionRepository extends JpaRepository<FunctionEntity, Long> {
    FunctionEntity findByName(String name);

    @Query(value = "select * from [function] inner join group_function on [function].id = group_function.function_id INNER JOIN [group] on [group].id = group_function.group_id where [group].id = ?1", nativeQuery = true)
    List<FunctionEntity> findRoleByGroupId(Long id_long);

    //    @Query(value = "select * from roledetail inner join role on roledetail.roleid = role.id where role.id = ?1", nativeQuery = true)
//    List<RoleDetailEntity> findRoleByRoleId(Long id_long);
    @Query(value = "select * from [function] inner join group_function on [function].id = group_function.function_id INNER JOIN [group] on [group].id = group_function.group_id inner join user_group on [group].id = user_group.group_id inner join [user] on user_group.user_id = [user].id where [user].username = ?1", nativeQuery = true)
    List<FunctionEntity> findRoleByUserName(String userName);

    @Query(value = "SELECT * FROM [function]", nativeQuery = true)
    List<FunctionEntity> findFuntion(Pageable pageable);

    Boolean existsByNameOrCode(String name, String code);
}
