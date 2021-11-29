package com.admin.adminapi.user.service;

import com.admin.adminapi.security.entity.Role;
import com.admin.adminapi.security.entity.User;
import com.admin.adminapi.security.entity.dto.UserDto;
import com.admin.adminapi.security.repo.RoleRepository;
import com.admin.adminapi.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired private RoleRepository roleRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;
    @Autowired private UserRepository userRepository;

    public Set<Role> getDefaultRole() {
        HashSet<Role> roles = new HashSet<>();
        Role role = roleRepository.findRoleByRole("ROLE_USER");
        roles.add(role);
        return roles;
    }

    public void saveUser(UserDto userDto) {
        User user = User.builder()
                .userName(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .roles(getDefaultRole())
                .build();
        userRepository.save(user);
    }
}
