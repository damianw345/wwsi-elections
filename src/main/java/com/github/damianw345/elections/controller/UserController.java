package com.github.damianw345.elections.controller;

import com.github.damianw345.elections.dto.UserDto;
import com.github.damianw345.elections.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RegistrationService registrationService;

    @GetMapping("/login")
    public void loginValidation() {
        // validated at BackendAuthenticatorFilter
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDto userDto) {
        registrationService.register(userDto);
    }
}
