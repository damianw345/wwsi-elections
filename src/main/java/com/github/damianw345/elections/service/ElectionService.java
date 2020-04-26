package com.github.damianw345.elections.service;

import com.github.damianw345.elections.dto.ElectionAreaDto;
import com.github.damianw345.elections.dto.ElectionTermDto;
import com.github.damianw345.elections.dto.UserDto;

import java.util.List;

public interface ElectionService {

    String registerToOnlineVoting(UserDto userDto, Integer electionAreaId);

    List<ElectionTermDto> findElectionTerms();

    List<ElectionAreaDto> findElectionAreas();

}
