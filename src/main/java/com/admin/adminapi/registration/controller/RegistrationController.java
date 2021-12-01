package com.admin.adminapi.registration.controller;

import com.admin.adminapi.registration.service.RegistrationService;
import com.admin.adminapi.security.entity.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RegistrationController {

    @Autowired private RegistrationService registrationService;

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody @Valid UserDto userDto) {
        return registrationService.registration(userDto);
    }
}
