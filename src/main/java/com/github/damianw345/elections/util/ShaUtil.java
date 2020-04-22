package com.github.damianw345.elections.util;

import com.google.common.hash.Hashing;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("UnstableApiUsage")
public class ShaUtil {

    public static String hash(String toHash) {
        return Hashing
                .sha512()
                .hashString(toHash, StandardCharsets.UTF_8)
                .toString();
    }
}
