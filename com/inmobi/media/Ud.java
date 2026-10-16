package com.inmobi.media;

import android.content.Context;
import com.ironsource.C3040d4;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Ud {

    /* renamed from: a, reason: collision with root package name */
    public static final C6 f2454a;
    public static int b;
    public static Integer c;

    static {
        C6 c6;
        Context d = Uc.d();
        if (d != null) {
            ConcurrentHashMap concurrentHashMap = C6.b;
            c6 = B6.a(d, "imtelemetrydboverflow");
        } else {
            c6 = null;
        }
        f2454a = c6;
        b = -1;
    }

    public static int a() {
        if (b == -1) {
            C6 c6 = f2454a;
            int i = 0;
            if (c6 != null) {
                Intrinsics.checkNotNullParameter("count", C3040d4.h.W);
                i = c6.f2249a.getInt("count", 0);
            }
            b = i;
        }
        return b;
    }
}
