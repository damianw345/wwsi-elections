package com.github.damianw345.elections.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Candidate {

    private String OkregWyborczy;
    private String KomitetNazwa;
    private Integer KandydatID;
    private String ImieNazwiskoKandydata;
    private String PartiaPoparcie;
}
