package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.google.android.gms.ads.AdError;
import io.bidmachine.ads.networks.vast.VastAdapter;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class c6 extends g5 implements l2 {
    private final JSONObject g;
    private final u h;
    private final AppLovinAdLoadListener i;
    private final boolean j;

    public c6(JSONObject jSONObject, u uVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        this(jSONObject, uVar, false, appLovinAdLoadListener, kVar);
    }

    private void a(JSONObject jSONObject) {
        String string = JsonUtils.getString(jSONObject, "type", AdError.UNDEFINED_DOMAIN);
        if ("applovin".equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Starting task for AppLovin ad...");
            }
            this.f464a.r0().a(new h6(jSONObject, this.g, this, this.f464a));
            return;
        }
        if (!VastAdapter.KEY.equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to process ad of unknown type: " + string);
            }
            failedToReceiveAdV2(new AppLovinError(AppLovinErrorCodes.INVALID_RESPONSE, "Unknown ad type: " + string));
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Starting task for VAST ad...");
            }
            this.f464a.r0().a(f6.a(jSONObject, this.g, this, this.f464a));
        }
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.i;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
        if (this.j || !(appLovinAd instanceof com.applovin.impl.sdk.ad.b)) {
            return;
        }
        this.f464a.g().a(c2.n, (com.applovin.impl.sdk.ad.b) appLovinAd);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        failedToReceiveAdV2(new AppLovinError(i, ""));
    }

    @Override // com.applovin.impl.l2
    public void failedToReceiveAdV2(AppLovinError appLovinError) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.i;
        if (appLovinAdLoadListener == null) {
            return;
        }
        if (appLovinAdLoadListener instanceof l2) {
            ((l2) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
        if (this.j) {
            return;
        }
        this.f464a.g().a(c2.o, this.h, appLovinError);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.g, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Processing ad...");
            }
            a(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.k(this.b, "No ads were returned from the server");
            }
            k7.a(this.h.e(), this.h.d(), this.g, this.f464a);
            failedToReceiveAdV2(AppLovinError.NO_FILL);
        }
    }

    public c6(JSONObject jSONObject, u uVar, boolean z, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskProcessAdResponse", kVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (uVar == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        this.g = jSONObject;
        this.h = uVar;
        this.i = appLovinAdLoadListener;
        this.j = z;
    }
}
