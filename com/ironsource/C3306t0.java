package com.ironsource;

import com.ironsource.C3288s;
import com.ironsource.InterfaceC3246p7;
import com.unity3d.mediation.LevelPlay;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.t0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3306t0 implements M3 {

    /* renamed from: a, reason: collision with root package name */
    private final C3047db f3832a;
    private final Map<LevelPlay.AdFormat, C3288s> b;

    public C3306t0(C3047db tools, Map<LevelPlay.AdFormat, C3288s> adFormatsConfigurations) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(adFormatsConfigurations, "adFormatsConfigurations");
        this.f3832a = tools;
        this.b = adFormatsConfigurations;
    }

    private final void b(InterfaceC3246p7.a aVar, String str, C3288s.d dVar) {
        Kc e = dVar.e();
        if (e != null) {
            P3 p3 = P3.Pacing;
            a(aVar.a(str, p3, new G3(e.a(), e.b(), e.c())), str, p3);
        }
    }

    @Override // com.ironsource.M3
    public void a(InterfaceC3246p7.a cappingService) {
        Intrinsics.checkNotNullParameter(cappingService, "cappingService");
        Iterator<Map.Entry<LevelPlay.AdFormat, C3288s>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, C3288s.d> entry : it.next().getValue().a().entrySet()) {
                String key = entry.getKey();
                C3288s.d value = entry.getValue();
                a(cappingService, key, value);
                b(cappingService, key, value);
            }
        }
    }

    private final void a(InterfaceC3246p7.a aVar, String str, C3288s.d dVar) {
        J3 b = dVar.b();
        if (b != null) {
            P3 p3 = P3.ShowCount;
            a(aVar.a(str, p3, new G3(b.a(), b.b(), b.c())), str, p3);
        }
    }

    private final void a(Object obj, String str, P3 p3) {
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
        if (m10244exceptionOrNullimpl != null) {
            this.f3832a.a(str, new K3().a(p3), m10244exceptionOrNullimpl.getMessage());
        }
    }
}
