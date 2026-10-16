package com.bytedance.adsdk.eli.eli;

/* loaded from: classes3.dex */
public class DbA extends RuntimeException {
    public DbA(String str, Throwable th) {
        super("Unable to parse expression:".concat(String.valueOf(str)), th);
    }
}
