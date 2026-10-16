package com.ironsource.mediationsdk.adunit.adapter.utility;

import com.ironsource.C3260q4;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class NativeAdProperties {
    private final AdOptionsPosition adOptionsPosition;
    private final AdOptionsPosition defaultAdOptionPosition;

    public NativeAdProperties(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.defaultAdOptionPosition = AdOptionsPosition.BOTTOM_LEFT;
        this.adOptionsPosition = getAdOptionsPosition(config);
    }

    public final AdOptionsPosition getAdOptionsPosition() {
        return this.adOptionsPosition;
    }

    private final AdOptionsPosition getAdOptionsPosition(JSONObject jSONObject) {
        String position = jSONObject.optString(AdOptionsPosition.AD_OPTIONS_POSITION_KEY, this.defaultAdOptionPosition.toString());
        try {
            Intrinsics.checkNotNullExpressionValue(position, "position");
            return AdOptionsPosition.valueOf(position);
        } catch (Exception e) {
            C3260q4.d().a(e);
            return this.defaultAdOptionPosition;
        }
    }
}
