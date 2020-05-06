package com.github.damianw345.elections.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HostName {

    private static final String HOST_NAME;

    static {
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            log.debug(e.getMessage(), e);
            hostName = "unknown";
        }
        HOST_NAME = hostName;
    }

    public static String currentHostName() {
        return HOST_NAME;
    }

}
