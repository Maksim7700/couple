package com.admin.adminapi.user.controller;

import com.admin.adminapi.security.entity.User;
import com.admin.adminapi.security.repo.UserRepository;
import com.admin.adminapi.security.responses.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired private UserRepository userRepository;

    @GetMapping("/about")
    public ResponseEntity<UserInfo> getUserInfo(Principal user){

        User userObj = userRepository.findUserByUserName(user.getName());

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(userObj.getUsername());
        userInfo.setLastName(userObj.getUsername());
        userInfo.setRoles(userObj.getAuthorities().toArray());

        return ResponseEntity.ok(userInfo);
    }
}
