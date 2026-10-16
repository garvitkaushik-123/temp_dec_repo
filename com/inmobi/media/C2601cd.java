package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.cd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2601cd {

    /* renamed from: a, reason: collision with root package name */
    public static final C2601cd f2538a = new C2601cd();

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0051, code lost:
    
        if (((com.inmobi.commons.core.configs.SignalsConfig) r0).getIce().getLocationEnabled() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a() {
        Intrinsics.checkNotNullExpressionValue("cd", "TAG");
        LinkedHashMap linkedHashMap = O2.f2380a;
        M2.a("signals", Uc.b(), null);
        Zc zc = Zc.f2508a;
        boolean sessionEnabled = ((SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getIce().getSessionEnabled();
        zc.getClass();
        Zc.e = sessionEnabled;
        if (!sessionEnabled) {
            Zc.d = null;
        }
        Zc.c();
        String h = Uc.f2453a.h();
        if (h != null) {
            Config a2 = M2.a("signals", h, null);
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
        }
        X6.f2480a.d();
    }
}
