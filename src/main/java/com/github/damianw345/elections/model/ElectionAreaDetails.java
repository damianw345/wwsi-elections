package com.github.damianw345.elections.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElectionAreaDetails {

    private String OkregWyborczyID;
    private String OkregWyborczy;
    private String Obszar;
    private String Opis;
}
