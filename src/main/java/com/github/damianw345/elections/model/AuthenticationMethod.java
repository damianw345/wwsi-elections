package com.github.damianw345.elections.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationMethod {

    private String MechanizmUwierzytelnieniaID;
    private String MechanizmNazwa;
}
