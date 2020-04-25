package com.github.damianw345.elections.controller;

import com.github.damianw345.elections.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.damianw345.elections.util.Constants.AUTH_TOKEN;
import static com.github.damianw345.elections.util.TokenToUserDto.buildUserDto;

@RestController
@RequestMapping("/elections")
@RequiredArgsConstructor
public class ElectionController {

    private final ElectionService electionService;

    @GetMapping("/election-area/{electionAreaId}/register")
    public void registerToOnlineVoting(@RequestHeader(name = AUTH_TOKEN) String token,
                                       @PathVariable("electionAreaId") Integer electionAreaId) {
        electionService.registerToOnlineVoting(buildUserDto(token), electionAreaId);
    }
}
