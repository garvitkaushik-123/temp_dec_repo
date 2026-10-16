package com.ironsource.adapters.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class LoadAdData {
    private final JSONObject localAdData;

    /* JADX WARN: Multi-variable type inference failed */
    public LoadAdData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String adUnitId() {
        String it = this.localAdData.optString("adUnitId");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final boolean isMultipleAdObjectsFlow() {
        return this.localAdData.optBoolean("isMultipleAdUnits", false);
    }

    public LoadAdData(JSONObject jSONObject) {
        this.localAdData = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public /* synthetic */ LoadAdData(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jSONObject);
    }
}
