package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ironsource.hd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3117hd {

    /* renamed from: a, reason: collision with root package name */
    private final Map<LevelPlay.AdFormat, a> f3339a;

    /* renamed from: com.ironsource.hd$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, b> f3340a;

        public a(JSONObject adFormatProviderOrder) {
            Intrinsics.checkNotNullParameter(adFormatProviderOrder, "adFormatProviderOrder");
            List<String> b = V9.b(adFormatProviderOrder.names());
            b = b == null ? CollectionsKt.emptyList() : b;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(b, 10)), 16));
            for (Object obj : b) {
                JSONArray optJSONArray = adFormatProviderOrder.optJSONArray((String) obj);
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                } else {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "adFormatProviderOrder.op…(adUnitId) ?: JSONArray()");
                }
                linkedHashMap.put(obj, new b(optJSONArray));
            }
            this.f3340a = linkedHashMap;
        }

        public final Map<String, b> a() {
            return this.f3340a;
        }
    }

    /* renamed from: com.ironsource.hd$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f3341a;

        public b(JSONArray providerOrder) {
            Intrinsics.checkNotNullParameter(providerOrder, "providerOrder");
            List<String> b = V9.b(providerOrder);
            Intrinsics.checkNotNullExpressionValue(b, "jsonArrayToStringList(providerOrder)");
            this.f3341a = b;
        }

        public final List<String> a() {
            return this.f3341a;
        }
    }

    public C3117hd(JSONObject providerOrder) {
        Intrinsics.checkNotNullParameter(providerOrder, "providerOrder");
        LevelPlay.AdFormat[] values = LevelPlay.AdFormat.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (LevelPlay.AdFormat adFormat : values) {
            JSONObject optJSONObject = providerOrder.optJSONObject(C3051df.a(adFormat));
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            } else {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "providerOrder.optJSONObj…dFormat)) ?: JSONObject()");
            }
            linkedHashMap.put(adFormat, new a(optJSONObject));
        }
        this.f3339a = linkedHashMap;
    }

    public final Map<LevelPlay.AdFormat, a> a() {
        return this.f3339a;
    }
}
