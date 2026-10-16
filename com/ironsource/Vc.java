package com.ironsource;

import com.ironsource.C3288s;
import com.ironsource.J7;
import com.unity3d.mediation.LevelPlay;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Vc {

    /* renamed from: a, reason: collision with root package name */
    private final C3047db f3100a;
    private final Map<LevelPlay.AdFormat, C3288s> b;

    public Vc(C3047db tools, Map<LevelPlay.AdFormat, C3288s> adFormatsConfigurations) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(adFormatsConfigurations, "adFormatsConfigurations");
        this.f3100a = tools;
        this.b = adFormatsConfigurations;
    }

    private final void b(J7.a aVar, String str, LevelPlay.AdFormat adFormat, C3288s.d dVar) {
        P3 p3 = P3.Delivery;
        Q4 c = dVar.c();
        a(aVar.a(str, adFormat, p3, new G3(c != null ? Boolean.valueOf(c.a()) : null, null, null, 6, null)), str, adFormat, p3);
    }

    private final void c(J7.a aVar, String str, LevelPlay.AdFormat adFormat, C3288s.d dVar) {
        Kc e = dVar.e();
        if (e != null) {
            P3 p3 = P3.Pacing;
            a(aVar.a(str, adFormat, p3, new G3(e.a(), e.b(), O3.Second)), str, adFormat, p3);
        }
    }

    public final void a(J7.a cappingService) {
        Intrinsics.checkNotNullParameter(cappingService, "cappingService");
        for (Map.Entry<LevelPlay.AdFormat, C3288s> entry : this.b.entrySet()) {
            LevelPlay.AdFormat key = entry.getKey();
            for (Map.Entry<String, C3288s.d> entry2 : entry.getValue().c().entrySet()) {
                String key2 = entry2.getKey();
                C3288s.d value = entry2.getValue();
                b(cappingService, key2, key, value);
                a(cappingService, key2, key, value);
                c(cappingService, key2, key, value);
            }
        }
    }

    private final void a(J7.a aVar, String str, LevelPlay.AdFormat adFormat, C3288s.d dVar) {
        J3 b = dVar.b();
        if (b != null) {
            P3 p3 = P3.ShowCount;
            a(aVar.a(str, adFormat, p3, new G3(b.a(), b.b(), b.c())), str, adFormat, p3);
        }
    }

    private final void a(Object obj, String str, LevelPlay.AdFormat adFormat, P3 p3) {
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
        if (m10244exceptionOrNullimpl != null) {
            this.f3100a.a(str, adFormat, new K3().a(p3), m10244exceptionOrNullimpl.getMessage());
        }
    }
}
