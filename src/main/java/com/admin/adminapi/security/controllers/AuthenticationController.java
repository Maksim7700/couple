package com.admin.adminapi.security.controllers;

import com.admin.adminapi.security.requests.AuthenticationRequest;
import com.admin.adminapi.security.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AuthenticationController {

    @Autowired UserDetailServiceImpl userDetailService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

        return userDetailService.getLoginResponseResponseEntity(authenticationRequest);
    }
}
