package com.igeek.common.util;

import java.util.UUID;

public class TokenGenerator {

    public static String createToken() {
        UUID uuid = UUID.randomUUID();
        return MD5Util.encode(uuid.toString());
    }
}
