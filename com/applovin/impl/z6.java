package com.applovin.impl;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class z6 {
    public static boolean a(String str, int i) {
        return str != null && i >= 0 && str.length() > i && str.charAt(i) == '1';
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : str.split("\\.")) {
            if (!c(str2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[a-zA-Z\\d_-]*$");
    }

    public static boolean a(String str) {
        if (str != null && str.length() >= 2) {
            String[] split = str.split("~", -1);
            if (split.length == 2 && "1".equals(split[0])) {
                return Pattern.matches("(\\d+(\\.\\d+)*)?", split[1]);
            }
            if (split.length == 3 && "2".equals(split[0]) && Pattern.matches("(\\d+(\\.\\d+)*)?", split[1]) && split[2].length() >= 3 && split[2].startsWith("dv.") && Pattern.matches("(\\d+(\\.\\d+)*)?", split[2].substring(3))) {
                return true;
            }
        }
        return false;
    }

    public static Boolean a(int i, String str) {
        if (!a(str)) {
            return null;
        }
        String[] split = str.split("~", -1);
        List asList = Arrays.asList(split[1].split("\\."));
        String valueOf = String.valueOf(i);
        boolean contains = asList.contains(valueOf);
        if (split[0].equals("1")) {
            return Boolean.valueOf(contains);
        }
        if (contains) {
            return Boolean.TRUE;
        }
        if (Arrays.asList(split[2].split("\\.")).contains(valueOf)) {
            return Boolean.FALSE;
        }
        return null;
    }
}
