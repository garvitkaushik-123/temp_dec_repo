package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* renamed from: com.ironsource.hc, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3116hc {

    /* renamed from: a, reason: collision with root package name */
    private final String f3337a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final JSONObject f;
    private final Map<String, JSONObject> g;
    private final String h;
    private final String i;
    private final boolean j;
    private C3116hc k;
    private final Lazy l;

    /* renamed from: com.ironsource.hc$a */
    static final class a extends Lambda implements Function0<NetworkSettings> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final NetworkSettings invoke() {
            String j = C3116hc.this.j();
            String l = C3116hc.this.l();
            String h = C3116hc.this.h();
            String k = C3116hc.this.k();
            JSONObject c = C3116hc.this.c();
            C3116hc c3116hc = C3116hc.this.k;
            JSONObject mergeJsons = IronSourceUtils.mergeJsons(c, c3116hc != null ? c3116hc.c() : null);
            JSONObject m = C3116hc.this.m();
            C3116hc c3116hc2 = C3116hc.this.k;
            JSONObject mergeJsons2 = IronSourceUtils.mergeJsons(m, c3116hc2 != null ? c3116hc2.m() : null);
            JSONObject e = C3116hc.this.e();
            C3116hc c3116hc3 = C3116hc.this.k;
            JSONObject mergeJsons3 = IronSourceUtils.mergeJsons(e, c3116hc3 != null ? c3116hc3.e() : null);
            JSONObject d = C3116hc.this.d();
            C3116hc c3116hc4 = C3116hc.this.k;
            JSONObject mergeJsons4 = IronSourceUtils.mergeJsons(d, c3116hc4 != null ? c3116hc4.d() : null);
            JSONObject g = C3116hc.this.g();
            C3116hc c3116hc5 = C3116hc.this.k;
            NetworkSettings networkSettings = new NetworkSettings(j, l, h, k, mergeJsons, mergeJsons2, mergeJsons3, mergeJsons4, IronSourceUtils.mergeJsons(g, c3116hc5 != null ? c3116hc5.g() : null));
            networkSettings.setIsMultipleInstances(C3116hc.this.o());
            networkSettings.setSubProviderId(C3116hc.this.n());
            networkSettings.setAdSourceNameForEvents(C3116hc.this.b());
            return networkSettings;
        }
    }

    public C3116hc(String providerName, JSONObject networkSettings) {
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        this.f3337a = providerName;
        this.b = providerName;
        String optString = networkSettings.optString(C3133ic.d, providerName);
        Intrinsics.checkNotNullExpressionValue(optString, "networkSettings.optStrin…,\n          providerName)");
        this.c = optString;
        String optString2 = networkSettings.optString(C3133ic.e, optString);
        Intrinsics.checkNotNullExpressionValue(optString2, "networkSettings.optStrin…roviderTypeForReflection)");
        this.d = optString2;
        Object opt = networkSettings.opt(C3133ic.f);
        this.e = opt instanceof String ? (String) opt : null;
        this.f = networkSettings.optJSONObject("application");
        LevelPlay.AdFormat[] values = LevelPlay.AdFormat.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (LevelPlay.AdFormat adFormat : values) {
            arrayList.add(C3051df.a(adFormat));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            String str = (String) obj;
            JSONObject optJSONObject = networkSettings.optJSONObject("adFormats");
            JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str) : null;
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            linkedHashMap.put(obj, optJSONObject2);
        }
        this.g = linkedHashMap;
        String optString3 = networkSettings.optString("spId", "0");
        Intrinsics.checkNotNullExpressionValue(optString3, "networkSettings.optStrin…B_PROVIDER_ID_FIELD, \"0\")");
        this.h = optString3;
        String optString4 = networkSettings.optString(C3133ic.f3361a);
        Intrinsics.checkNotNullExpressionValue(optString4, "networkSettings.optString(AD_SOURCE_NAME_FIELD)");
        this.i = optString4;
        this.j = networkSettings.optBoolean(C3133ic.c, false);
        this.l = LazyKt.lazy(new a());
    }

    public final String b() {
        return this.i;
    }

    public final JSONObject c() {
        return this.f;
    }

    public final JSONObject d() {
        JSONObject mergeJsons = IronSourceUtils.mergeJsons(this.g.get("banner"), this.f);
        Intrinsics.checkNotNullExpressionValue(mergeJsons, "mergeJsons(\n            …EY], applicationSettings)");
        return mergeJsons;
    }

    public final JSONObject e() {
        JSONObject mergeJsons = IronSourceUtils.mergeJsons(this.g.get("interstitial"), this.f);
        Intrinsics.checkNotNullExpressionValue(mergeJsons, "mergeJsons(\n            …EY], applicationSettings)");
        return mergeJsons;
    }

    public final NetworkSettings f() {
        return (NetworkSettings) this.l.getValue();
    }

    public final JSONObject g() {
        JSONObject mergeJsons = IronSourceUtils.mergeJsons(this.g.get("nativeAd"), this.f);
        Intrinsics.checkNotNullExpressionValue(mergeJsons, "mergeJsons(\n            …EY], applicationSettings)");
        return mergeJsons;
    }

    public final String h() {
        return this.d;
    }

    public final String i() {
        return this.b;
    }

    public final String j() {
        return this.f3337a;
    }

    public final String k() {
        return this.e;
    }

    public final String l() {
        return this.c;
    }

    public final JSONObject m() {
        JSONObject mergeJsons = IronSourceUtils.mergeJsons(this.g.get("rewarded"), this.f);
        Intrinsics.checkNotNullExpressionValue(mergeJsons, "mergeJsons(\n            …     applicationSettings)");
        return mergeJsons;
    }

    public final String n() {
        return this.h;
    }

    public final boolean o() {
        return this.j;
    }

    public final Map<String, JSONObject> a() {
        return this.g;
    }

    public final void b(C3116hc c3116hc) {
        this.k = c3116hc;
    }
}
