package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public abstract class D4 {
    public static final P9 a(C2962yc c2962yc) {
        Intrinsics.checkNotNullParameter(c2962yc, "<this>");
        P9 p9 = new P9();
        byte[] value = c2962yc.c;
        if (value != null) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value.length == 0) {
                p9.b = new byte[0];
            } else {
                byte[] bArr = new byte[value.length];
                p9.b = bArr;
                System.arraycopy(value, 0, bArr, 0, value.length);
            }
        }
        p9.f = c2962yc.b;
        p9.e = c2962yc.e;
        p9.d = c2962yc.f2765a;
        Integer num = c2962yc.d;
        p9.c = Integer.valueOf(num != null ? num.intValue() : 0);
        return p9;
    }

    public static final boolean a(String str) {
        if (str == null || StringsKt.trim((CharSequence) str).toString().length() == 0) {
            return true;
        }
        return (StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) ? false : true;
    }

    public static final void a(Thread thread, String name) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            thread.start();
        } catch (InternalError e) {
            e.toString();
        }
    }
}
