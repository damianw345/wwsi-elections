package com.github.damianw345.elections.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    // DBAs rejected to pass login and password to the application layer, so this is kind of workaround, as they return only this string
    // when authentication is successful
    public static final String SUCCESSFUL_LOGIN = "sukces logowania";
}
