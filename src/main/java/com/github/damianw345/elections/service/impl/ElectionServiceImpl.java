package com.github.damianw345.elections.service.impl;

import com.github.damianw345.elections.dto.UserDto;
import com.github.damianw345.elections.repository.ElectionsRepository;
import com.github.damianw345.elections.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElectionServiceImpl implements ElectionService {

    private final ElectionsRepository electionsRepository;

    @Override
    public String registerToOnlineVoting(UserDto userDto, Integer electionAreaId) {
        return electionsRepository.registerToOnlineVoting(
                userDto.getLogin(),
                userDto.getHashedPassword(),
                electionAreaId
        );
    }
}
