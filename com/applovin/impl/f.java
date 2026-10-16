package com.applovin.impl;

import com.applovin.impl.c2;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class f extends d2 {
    public f(com.applovin.impl.sdk.k kVar) {
        super(kVar, c2.b.AD);
    }

    public void a(c2 c2Var, com.applovin.impl.sdk.ad.b bVar) {
        a(c2Var, bVar, new HashMap());
    }

    public void a(c2 c2Var, com.applovin.impl.sdk.ad.b bVar, Map map) {
        a(c2Var, bVar != null ? bVar.getAdZone() : null, bVar, null, map);
    }

    public void a(c2 c2Var, u uVar, AppLovinError appLovinError) {
        a(c2Var, uVar, null, appLovinError, new HashMap());
    }

    private void a(c2 c2Var, u uVar, com.applovin.impl.sdk.ad.b bVar, AppLovinError appLovinError, Map map) {
        if (((Boolean) this.f432a.a(v4.H)).booleanValue() && this.f432a.H0()) {
            return;
        }
        if (bVar != null) {
            map.putAll(e2.a((AppLovinAdImpl) bVar));
        } else if (uVar != null) {
            CollectionUtils.putStringIfValid("ad_zone_id", uVar.e(), map);
            MaxAdFormat d = uVar.d();
            if (d != null) {
                CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, d.getLabel(), map);
            }
        }
        AppLovinAdSize a2 = a(uVar, bVar);
        if (a2 != null) {
            CollectionUtils.putStringIfValid("ad_size", a2.getLabel(), map);
        }
        if (appLovinError != null) {
            CollectionUtils.putStringIfValid("error_message", appLovinError.getMessage(), map);
            CollectionUtils.putStringIfValid(AndroidBridgeConstants.ERROR_CODE, String.valueOf(appLovinError.getCode()), map);
        }
        d(c2Var, map);
    }

    private AppLovinAdSize a(u uVar, com.applovin.impl.sdk.ad.b bVar) {
        AppLovinAdSize f = uVar != null ? uVar.f() : null;
        if (f != null) {
            return f;
        }
        if (bVar != null) {
            return bVar.getSize();
        }
        return null;
    }
}
