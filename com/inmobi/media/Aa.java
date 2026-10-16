package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public abstract class Aa {

    /* renamed from: a, reason: collision with root package name */
    public static C2576b5 f2234a;
    public static F3 b;
    public static final AtomicBoolean c = new AtomicBoolean(false);

    public static void a() {
        LinkedHashMap linkedHashMap = O2.f2380a;
        if (((AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getPingV2().getEnabled() && c.compareAndSet(false, true)) {
            Pa pa = new Pa();
            f2234a = new C2576b5(pa);
            b = new F3(pa);
            C2576b5 c2576b5 = f2234a;
            if (c2576b5 != null) {
                O4 o4 = c2576b5.e;
                o4.getClass();
                Ca ca = Ca.c;
                if (o4.a(ca)) {
                    o4.d = ca;
                    o4.a();
                    o4.c();
                    o4.d();
                }
            }
            F3 f3 = b;
            if (f3 != null) {
                W9 w9 = f3.e;
                w9.getClass();
                Ca ca2 = Ca.c;
                if (w9.a(ca2)) {
                    w9.d = ca2;
                    w9.a();
                }
            }
        }
    }
}
