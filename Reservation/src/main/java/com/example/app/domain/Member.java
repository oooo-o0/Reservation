package com.example.app.domain;

import com.example.app.validation.LoginGroup;
import com.example.app.validation.RegisterGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Member {
    @NotBlank(groups = RegisterGroup.class)
    private String name;

    @NotBlank(groups = {RegisterGroup.class, LoginGroup.class})
    @Email(groups = {RegisterGroup.class})
    private String email;

    @NotBlank(groups = RegisterGroup.class)
    private String emailConf;

    @NotBlank(groups = {RegisterGroup.class, LoginGroup.class})
    private String password;
}
