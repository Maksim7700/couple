package com.admin.adminapi.security.requests;

import lombok.Getter;

@Getter
public class AuthenticationRequest {

    private String userName;
    private String password;
}
