package com.admin.adminapi.registration.service;

import com.admin.adminapi.security.entity.dto.UserDto;
import com.admin.adminapi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {

    @Autowired
    private UserService userService;

    public ResponseEntity<String> registration(UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body("User created.");
    }
}
