package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e6 extends g5 {
    private final JSONObject g;
    private final AppLovinNativeAdLoadListener h;

    public e6(JSONObject jSONObject, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskProcessNativeAdResponse", kVar);
        this.g = jSONObject;
        this.h = appLovinNativeAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.g, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Processing ad...");
            }
            this.f464a.r0().a(new com.applovin.impl.sdk.nativeAd.b(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()), this.g, this.h, this.f464a));
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.k(this.b, "No ads were returned from the server");
        }
        k7.a("native_native", MaxAdFormat.NATIVE, this.g, this.f464a);
        this.h.onNativeAdLoadFailed(AppLovinError.NO_FILL);
    }
}
