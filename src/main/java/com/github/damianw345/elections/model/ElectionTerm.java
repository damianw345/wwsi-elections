package com.github.damianw345.elections.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ElectionTerm {
    private String WyboryTerminID;
    private String Opis;
    private Date Od;
    private Date Do;
}
