package com.admin.adminapi.user.controller;

import com.admin.adminapi.security.entity.User;
import com.admin.adminapi.security.entity.dto.UserDto;
import com.admin.adminapi.security.repo.UserRepository;
import com.admin.adminapi.security.responses.UserInfo;
import com.admin.adminapi.security.service.UserDetailServiceImpl;
import com.admin.adminapi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public ResponseEntity<UserInfo> getUserInfo(Principal user){

        User userObj = userRepository.findUserByUserName(user.getName());

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(userObj.getUsername());
        userInfo.setLastName(userObj.getUsername());
        userInfo.setRoles(userObj.getAuthorities().toArray());

        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.ok("OK");
    }
}
