package com.github.damianw345.elections.dto;

import com.github.damianw345.elections.model.Committee;
import lombok.Value;

@Value
public class CommitteeDto {
    int committeeId;
    String committeeName;
    int candidateCount;

    public static CommitteeDto of(Committee committee) {
        return new CommitteeDto(
                committee.getKomitetNr(),
                committee.getKomitetNazwa(),
                committee.getLiczbaKandydatów()
        );
    }
}
