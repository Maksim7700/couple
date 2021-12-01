package com.admin.adminapi.security.entity.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message = "Username can not be empty.")
    @Size(min = 3, message = "Username length can not be less than 3.")
    private String username;
    private String password;
    private String email;
}
