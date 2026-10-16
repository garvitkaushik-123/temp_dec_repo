package com.bytedance.sdk.component.utils;

import java.io.Closeable;

/* loaded from: classes3.dex */
public class aAs {
    public static void eli(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
