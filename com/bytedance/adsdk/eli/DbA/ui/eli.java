package com.bytedance.adsdk.eli.DbA.ui;

/* loaded from: classes3.dex */
public class eli {
    public static boolean DbA(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public static boolean Os(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean aGH(char c) {
        return '+' == c || '-' == c || '*' == c || '/' == c || '%' == c || '=' == c || '>' == c || '<' == c || '!' == c || '&' == c || '|' == c || '?' == c || ':' == c;
    }

    public static boolean eli(char c) {
        return c == ' ';
    }
}
