package com.github.damianw345.elections.model.area;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElectionAreaDetails {

    private int OkregWyborczyID;
    private String OkregWyborczy;
    private String Obszar;
    private String Opis;
}
