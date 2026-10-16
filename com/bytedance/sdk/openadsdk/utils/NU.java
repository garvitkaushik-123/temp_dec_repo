package com.bytedance.sdk.openadsdk.utils;

import java.io.Closeable;

/* loaded from: classes3.dex */
public class NU {
    public static void eli(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }
}
