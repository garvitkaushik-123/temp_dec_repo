package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class V3 {

    /* renamed from: a, reason: collision with root package name */
    private final C3288s f3087a;
    private final C3288s b;
    private final U2 c;
    private final Ab d;
    private final C3409z1 e;
    private final Map<LevelPlay.AdFormat, C3288s> f;

    public V3(JSONObject configurations) {
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        C3288s c3288s = new C3288s(a(configurations, "rewarded"));
        this.f3087a = c3288s;
        C3288s c3288s2 = new C3288s(a(configurations, "interstitial"));
        this.b = c3288s2;
        this.c = new U2(a(configurations, "banner"));
        this.d = new Ab(a(configurations, "nativeAd"));
        JSONObject optJSONObject = configurations.optJSONObject("application");
        this.e = new C3409z1(optJSONObject == null ? new JSONObject() : optJSONObject);
        this.f = MapsKt.mapOf(TuplesKt.to(LevelPlay.AdFormat.INTERSTITIAL, c3288s2), TuplesKt.to(LevelPlay.AdFormat.REWARDED, c3288s));
    }

    public final Map<LevelPlay.AdFormat, C3288s> a() {
        return this.f;
    }

    public final C3409z1 b() {
        return this.e;
    }

    public final U2 c() {
        return this.c;
    }

    public final Ab d() {
        return this.d;
    }

    private final JSONObject a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("adFormats");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str) : null;
        return optJSONObject2 == null ? new JSONObject() : optJSONObject2;
    }
}
