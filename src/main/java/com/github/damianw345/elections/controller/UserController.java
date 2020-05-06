package com.github.damianw345.elections.controller;

import com.github.damianw345.elections.dto.UserDto;
import com.github.damianw345.elections.exception.AppRuntimeException;
import com.github.damianw345.elections.service.ElectionService;
import com.github.damianw345.elections.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.damianw345.elections.exception.code.AppExceptionCode.E004;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RegistrationService registrationService;
    private final ElectionService electionService;

    @GetMapping("/login")
    public void loginValidation() {
        // login validated at BackendAuthenticatorFilter

        if (electionService.findElectionTerms().isEmpty()) {
            throw new AppRuntimeException(E004);
        }
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDto userDto) {
        registrationService.register(userDto);
    }
}
