package com.github.damianw345.elections.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class AppExceptionHandler {

    @ExceptionHandler({AppRuntimeException.class})
    @ResponseBody
    public ExceptionInfo handleTrException(HttpServletResponse response, AppRuntimeException e) {
        ExceptionInfo exceptionInfo = buildExceptionInfo(e);
        logMessage(exceptionInfo.toString(), e);

        // fixme set http status depending on error type
        response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());

        return exceptionInfo;
    }

    private ExceptionInfo buildExceptionInfo(AppRuntimeException e) {
        return ExceptionInfo.of(e);
    }

    private void logMessage(String message, AppRuntimeException e) {
        log.warn(message, e);
    }

}
