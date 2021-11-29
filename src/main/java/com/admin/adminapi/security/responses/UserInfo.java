package com.admin.adminapi.security.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

    private String firstName;
    private String lastName;
    private String userName;
    private Object roles;
}
