package com.github.damianw345.elections.controller;

import com.github.damianw345.elections.dto.CandidateDto;
import com.github.damianw345.elections.dto.CommitteeDto;
import com.github.damianw345.elections.dto.ElectionAreaDto;
import com.github.damianw345.elections.dto.ElectionTermDto;
import com.github.damianw345.elections.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/terms")
    public List<ElectionTermDto> listElectionTerms() {
        return electionService.findElectionTerms();
    }

    @GetMapping("/areas")
    public List<ElectionAreaDto> listElectionAreas() {
        return electionService.findElectionAreas();
    }

    @GetMapping("/committees")
    public List<CommitteeDto> findCommittees(
            @RequestParam("electionTermId") int electionTermId,
            @RequestParam("electionAreaId") int electionAreaId
    ) {
        return electionService.findCommittees(electionTermId, electionAreaId);
    }

    @GetMapping("/candidates")
    public List<CandidateDto> findCandidates(
            @RequestParam("electionTermId") int electionTermId,
            @RequestParam("electionAreaId") int electionAreaId,
            @RequestParam("committeeId") int committeeId
    ) {
        return electionService.findCandidates(electionTermId, electionAreaId, committeeId);
    }
}
