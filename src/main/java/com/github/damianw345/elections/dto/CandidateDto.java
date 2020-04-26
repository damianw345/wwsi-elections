package com.github.damianw345.elections.dto;

import com.github.damianw345.elections.model.Candidate;
import lombok.Value;

@Value
public class CandidateDto {
    int candidateId;
    String electionArea;
    String committeeName;
    String candidateNameSurname;
    String supportingParty;

    public static CandidateDto of(Candidate candidate){
        return new CandidateDto(
                candidate.getKandydatID(),
                candidate.getOkregWyborczy(),
                candidate.getKomitetNazwa(),
                candidate.getImieNazwiskoKandydata(),
                candidate.getPartiaPoparcie()
        );
    }
}
