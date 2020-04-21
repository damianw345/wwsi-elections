package com.github.damianw345.elections.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElectionAreaServer {

    private String OkregWyborczyID;
    private String SerwerSQL;
    private String BazaSQL;
    private String DataUtworzenia;
    private String DataWycofania;
}
