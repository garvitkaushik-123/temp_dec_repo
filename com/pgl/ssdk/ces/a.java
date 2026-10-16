package com.pgl.ssdk.ces;

import android.content.Context;

/* loaded from: classes6.dex */
public final class a {
    public static native Object meta(int i, Context context, Object obj);

    public static Object njss(int i, Object obj) {
        try {
            b h = b.h();
            if (h != null) {
                return h.a(i, obj);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
