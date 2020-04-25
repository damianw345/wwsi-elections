package com.github.damianw345.elections.dto;

import lombok.Value;

@Value
public class VoteDto {
    Integer candidateId;
    Integer electionTermId;
    Integer electionAreaId;
    Integer authMethodId;
}
