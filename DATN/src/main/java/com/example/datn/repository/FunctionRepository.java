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

    @Query(value = "select * from [functions] inner join group_function on [functions].id = group_function.function_id INNER JOIN [groupss] on [groupss].id = group_function.group_id where [groupss].id = ?1", nativeQuery = true)
    List<FunctionEntity> findFunctionByGroupId(Long id_long);

    //    @Query(value = "select * from roledetail inner join role on roledetail.roleid = role.id where role.id = ?1", nativeQuery = true)
//    List<RoleDetailEntity> findRoleByRoleId(Long id_long);
    @Query(value = "select * from [functions] inner join group_function on [functions].id = group_function.function_id INNER JOIN [groupss] on [groupss].id = group_function.group_id inner join user_group on [groupss].id = user_group.group_id inner join [users] on user_group.user_id = [users].id where [users].username = ?1", nativeQuery = true)
    List<FunctionEntity> findFunctionByUserName(String userName);

    @Query(value = "SELECT * FROM [functions]", nativeQuery = true)
    List<FunctionEntity> findFunction(Pageable pageable);

    Boolean existsByNameOrCode(String name, String code);
}
