package com.inmobi.media;

import com.ironsource.C3040d4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class I5 {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f2313a;
    public static String b;
    public static final String c;

    static {
        Lazy lazy = LazyKt.lazy(H5.f2303a);
        f2313a = lazy;
        c = "I5";
        Intrinsics.checkNotNull("I5");
        C6 c6 = (C6) lazy.getValue();
        String str = null;
        if (c6 != null) {
            Intrinsics.checkNotNullParameter("cip", C3040d4.h.W);
            str = c6.f2249a.getString("cip", null);
        }
        b = str;
    }

    public static void a() {
        b = null;
        C6 c6 = (C6) f2313a.getValue();
        if (c6 != null) {
            c6.a("cip");
        }
        Intrinsics.checkNotNull(c);
    }
}
