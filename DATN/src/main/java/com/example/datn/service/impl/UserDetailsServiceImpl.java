package com.example.datn.service.impl;

import com.example.datn.entity.GroupEntity;
import com.example.datn.entity.UserEntity;
import com.example.datn.repository.GroupRepository;
import com.example.datn.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        } else {
            List<GroupEntity> groupEntities = groupRepository.findGroupByUserName(userEntity.getUsername());
            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            if (groupEntities != null) {
                for (GroupEntity groupEntity : groupEntities) {
                    String groupRoleCode = groupEntity.getCode();
                    GrantedAuthority authority = new SimpleGrantedAuthority(groupRoleCode);
                    grantList.add(authority);
                }
            }
            return (UserDetails) new User(userEntity.getUsername(),
                    userEntity.getPassword(), grantList);
        }
    }
}
