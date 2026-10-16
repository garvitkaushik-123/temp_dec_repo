package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.y, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3390y implements InterfaceC3128i7 {

    /* renamed from: a, reason: collision with root package name */
    private final K8 f3942a;

    public C3390y(K8 sessionDepthService) {
        Intrinsics.checkNotNullParameter(sessionDepthService, "sessionDepthService");
        this.f3942a = sessionDepthService;
    }

    @Override // com.ironsource.InterfaceC3128i7
    public void a(Map<String, Object> output) {
        Intrinsics.checkNotNullParameter(output, "output");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(N6.I0, Integer.valueOf(this.f3942a.a(LevelPlay.AdFormat.INTERSTITIAL)));
        output.put("interstitial", linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put(N6.I0, Integer.valueOf(this.f3942a.a(LevelPlay.AdFormat.REWARDED)));
        output.put(N6.F0, linkedHashMap2);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put(N6.I0, Integer.valueOf(this.f3942a.a(LevelPlay.AdFormat.BANNER)));
        output.put("banner", linkedHashMap3);
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        linkedHashMap4.put(N6.I0, Integer.valueOf(this.f3942a.a(LevelPlay.AdFormat.NATIVE_AD)));
        output.put("nativeAd", linkedHashMap4);
    }
}
