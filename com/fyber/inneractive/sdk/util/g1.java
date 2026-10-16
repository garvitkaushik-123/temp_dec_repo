package com.fyber.inneractive.sdk.util;

/* loaded from: classes4.dex */
public abstract class g1 {
    public static String a(String str, int i) {
        return (i <= 0 || str.length() <= i) ? str : str.substring(0, i - 3) + "...";
    }
}
