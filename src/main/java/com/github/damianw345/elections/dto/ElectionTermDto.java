package com.github.damianw345.elections.dto;

import com.github.damianw345.elections.model.ElectionTerm;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ElectionTermDto {
    Integer electionTermId;
    String description;
    LocalDateTime since;
    LocalDateTime to;

    public static ElectionTermDto of(ElectionTerm electionTerm) {
        return new ElectionTermDto(
                electionTerm.getWyboryTerminID(),
                electionTerm.getOpis(),
                electionTerm.getOd(),
                electionTerm.getDo()
        );
    }
}
