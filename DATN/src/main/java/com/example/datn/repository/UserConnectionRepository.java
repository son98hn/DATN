package com.example.datn.repository;

import com.example.datn.entity.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author: Pham Ngoc Son
 * <p>
 * Oct 04, 2021
 */
@Repository
@Transactional
public interface UserConnectionRepository extends JpaRepository<UserConnection, Long> {
    UserConnection findByProviderId(Long providerId);
}
