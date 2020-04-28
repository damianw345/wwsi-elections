package com.github.damianw345.elections.controller;

import com.github.damianw345.elections.dto.VoteDto;
import com.github.damianw345.elections.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.damianw345.elections.util.Constants.AUTH_TOKEN;
import static com.github.damianw345.elections.util.TokenToUserDto.buildUserDto;

@RestController
@RequestMapping("/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public String voteOnline(@RequestHeader(name = AUTH_TOKEN) String token,
                             @RequestBody VoteDto voteDto) {
        return voteService.voteOnline(buildUserDto(token), voteDto);
    }
}
