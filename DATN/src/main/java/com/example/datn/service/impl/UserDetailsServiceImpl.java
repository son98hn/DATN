package com.example.datn.service.impl;

import com.example.datn.entity.GroupRoleEntity;
import com.example.datn.entity.UserEntity;
import com.example.datn.repository.GroupRoleRepository;
import com.example.datn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRoleRepository groupRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        } else {
            List<GroupRoleEntity> groupRoleEntities = groupRoleRepository.findGroupRoleByUserName(userEntity.getUserName());
            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            if (groupRoleEntities != null) {
                for (GroupRoleEntity groupRoleEntity : groupRoleEntities) {
                    String groupRoleCode = groupRoleEntity.getCode();
                    GrantedAuthority authority = new SimpleGrantedAuthority(groupRoleCode);
                    grantList.add(authority);
                }
            }
            return (UserDetails) new User(userEntity.getUserName(),
                    userEntity.getPassword(), grantList);
        }
    }
}
