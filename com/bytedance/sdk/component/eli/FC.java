package com.bytedance.sdk.component.eli;

/* loaded from: classes3.dex */
class FC {
    private static boolean eli;

    static void eli(RuntimeException runtimeException) {
        if (eli) {
            throw runtimeException;
        }
    }
}
