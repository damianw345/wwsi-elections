package com.github.damianw345.elections.model.area;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElectionArea {

    private String OkregWyborczyID;
    private String OkregWyborczy;
    private String Kandydatow;
}
