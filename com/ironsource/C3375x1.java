package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* renamed from: com.ironsource.x1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3375x1 {

    /* renamed from: a, reason: collision with root package name */
    private final Map<LevelPlay.AdFormat, C3238p> f3929a;

    public C3375x1(JSONObject applicationAuctionSettings) {
        Intrinsics.checkNotNullParameter(applicationAuctionSettings, "applicationAuctionSettings");
        LevelPlay.AdFormat[] values = LevelPlay.AdFormat.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (LevelPlay.AdFormat adFormat : values) {
            JSONObject optJSONObject = applicationAuctionSettings.optJSONObject(C3051df.a(adFormat));
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            } else {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "applicationAuctionSettin…ormatKey) ?: JSONObject()");
            }
            linkedHashMap.put(adFormat, new C3238p(optJSONObject));
        }
        this.f3929a = linkedHashMap;
    }

    public final Map<LevelPlay.AdFormat, C3238p> a() {
        return this.f3929a;
    }
}
