package com.github.damianw345.elections.util;

import com.github.damianw345.elections.dto.UserDto;
import com.github.damianw345.elections.exception.AppRuntimeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

import static com.github.damianw345.elections.exception.code.AppExceptionCode.E001;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenToUserDto {

    public static UserDto buildUserDto(String base64AuthToken) {
        return Optional.ofNullable(base64AuthToken)
                .map(token -> new String(Base64.getDecoder().decode(token)))
                .map(Objects::toString)
                .map(credentials -> credentials.split(":"))
                .map(credentials -> new UserDto(credentials[0], credentials[1]))
                .orElseThrow(() -> new AppRuntimeException(E001));
    }
}
