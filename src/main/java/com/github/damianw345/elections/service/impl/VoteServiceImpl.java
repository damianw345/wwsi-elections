package com.github.damianw345.elections.service.impl;

import com.github.damianw345.elections.dto.UserDto;
import com.github.damianw345.elections.dto.VoteDto;
import com.github.damianw345.elections.repository.ElectionsRepository;
import com.github.damianw345.elections.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final ElectionsRepository electionsRepository;

    @Override
    public String voteOnline(UserDto userDto, VoteDto voteDto) {
        return electionsRepository.voteOnline(
                voteDto.getCandidateId(),
                voteDto.getElectionTermId(),
                voteDto.getElectionAreaId(),
                userDto.getLogin(),
                userDto.getHashedPassword(),
                voteDto.getAuthMethodId()
        );
    }
}
