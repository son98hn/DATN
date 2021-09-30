package com.example.datn.repository;

import com.example.datn.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UserEntity> findUser(Pageable pageable);

    Boolean existsByUsernameOrEmailOrPhone(String userName, String email, String phone);

}
