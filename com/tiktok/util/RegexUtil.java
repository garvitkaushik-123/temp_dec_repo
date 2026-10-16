package com.tiktok.util;

import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class RegexUtil {
    public static boolean validateAppId(String appId) {
        return Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]*(\\.[a-zA-Z][a-zA-Z0-9_]*)+$").matcher(appId).matches();
    }

    public static boolean validateTTAppId(String ttAppId) {
        return Pattern.compile("^(\\d+,)*\\d+$").matcher(ttAppId).matches();
    }
}
