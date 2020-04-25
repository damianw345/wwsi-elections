package com.github.damianw345.elections.service;

import com.github.damianw345.elections.dto.UserDto;

public interface ElectionService {

    String registerToOnlineVoting(UserDto userDto, Integer electionAreaId);
}
