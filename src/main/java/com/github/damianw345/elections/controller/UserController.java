package com.github.damianw345.elections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/login")
    public void loginValidation() {
        // validated at BackendAuthenticatorFilter
    }

    @GetMapping("/register")
    public void register() {
        // TODO
    }
}
