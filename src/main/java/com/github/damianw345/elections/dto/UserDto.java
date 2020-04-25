package com.github.damianw345.elections.dto;

import com.github.damianw345.elections.util.ShaUtil;
import lombok.Value;

@Value
public class UserDto {
    String login;
    String password;

    public String getHashedPassword() {
        return ShaUtil.hash(password);
    }
}
