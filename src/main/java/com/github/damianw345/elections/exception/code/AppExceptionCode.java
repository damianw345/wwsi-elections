package com.github.damianw345.elections.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppExceptionCode {
    E001("Incorrect auth token"),
    E002("User already exists"),
    E003("Counties deserialization error"),
    ;

    private final String message;
}
