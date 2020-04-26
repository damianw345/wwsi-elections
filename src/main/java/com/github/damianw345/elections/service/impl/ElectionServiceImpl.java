package com.github.damianw345.elections.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.damianw345.elections.dto.ElectionAreaDto;
import com.github.damianw345.elections.dto.ElectionTermDto;
import com.github.damianw345.elections.dto.UserDto;
import com.github.damianw345.elections.model.area.ElectionAreaDetails;
import com.github.damianw345.elections.repository.ElectionsRepository;
import com.github.damianw345.elections.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<ElectionTermDto> findElectionTerms() {
        return electionsRepository
                .findElectionTerms()
                .stream()
                .map(ElectionTermDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<ElectionAreaDto> findElectionAreas() {
        return electionsRepository.findElectionAreasWithDetails()
                .stream()
                .map(ElectionAreaDto::of)
                .collect(Collectors.toList());
    }
}
