package com.github.damianw345.elections.exception;

import com.github.damianw345.elections.exception.code.AppExceptionCode;
import lombok.Getter;


@Getter
public class AppRuntimeException extends RuntimeException {

    private final AppExceptionCode code;

    public AppRuntimeException(AppExceptionCode code) {
        super(String.format("code: %s message: %s", code.name(), code.getMessage()));
        this.code = code;
    }

    public AppRuntimeException(AppExceptionCode code, Throwable cause) {
        super(String.format("code: %s message: %s cause: %s", code.name(), code.getMessage(), cause.getMessage()), cause);
        this.code = code;
    }

}
