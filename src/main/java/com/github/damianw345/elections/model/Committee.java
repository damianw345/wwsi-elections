package com.github.damianw345.elections.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Committee {
    private int KomitetNr;
    private String KomitetNazwa;
    private int LiczbaKandydatów;
}
