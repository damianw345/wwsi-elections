package com.github.damianw345.elections.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.github.damianw345.elections.util.HostName.currentHostName;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionInfo {

    private static final Clock clock = Clock.systemUTC();

    private String message;
    private String code;
    private LocalDateTime dateTime;
    private String refNumber;
    private String hostName;

    public static ExceptionInfo of(AppRuntimeException e) {
        return builder()
                .message(e.getCode().getMessage())
                .code(e.getCode().toString())
                .dateTime(LocalDateTime.now(clock))
                .refNumber(UUID.randomUUID().toString())
                .hostName(currentHostName())
                .build();
    }
}
