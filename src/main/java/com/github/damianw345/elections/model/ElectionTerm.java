package com.github.damianw345.elections.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ElectionTerm {
    private Integer WyboryTerminID;
    private String Opis;
    private LocalDateTime Od;
    private LocalDateTime Do;
}
