package com.github.damianw345.elections.service;

import com.github.damianw345.elections.dto.UserDto;
import com.github.damianw345.elections.dto.VoteDto;

public interface VoteService {
    String voteOnline(UserDto userDto, VoteDto voteDto);
}
