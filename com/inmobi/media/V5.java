package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class V5 {

    /* renamed from: a, reason: collision with root package name */
    public static C6 f2460a;

    public static final C6 a() {
        C6 c6;
        if (f2460a == null) {
            Context d = Uc.d();
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                c6 = B6.a(d, "CrashSession-store");
            } else {
                c6 = null;
            }
            f2460a = c6;
        }
        return f2460a;
    }

    public static final long a(AbstractC2822q3 crashType) {
        Intrinsics.checkNotNullParameter(crashType, "crashType");
        C6 a2 = a();
        if (a2 == null) {
            return 0L;
        }
        String key = crashType.b;
        Intrinsics.checkNotNullParameter(key, "key");
        return a2.f2249a.getLong(key, 0L);
    }
}
