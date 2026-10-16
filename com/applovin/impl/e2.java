package com.applovin.impl;

import android.net.Uri;
import android.text.format.Formatter;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinAdSize;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class e2 {
    public static Map a(AppLovinAdImpl appLovinAdImpl) {
        HashMap hashMap = new HashMap(10);
        if (appLovinAdImpl != null) {
            CollectionUtils.putStringIfValid("ad_domain", appLovinAdImpl.getAdDomain(), hashMap);
            CollectionUtils.putStringIfValid("ad_id", String.valueOf(appLovinAdImpl.getAdIdNumber()), hashMap);
            MaxAdFormat d = appLovinAdImpl.getAdZone().d();
            CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, d != null ? d.getLabel() : null, hashMap);
            CollectionUtils.putStringIfValid("ad_zone_id", appLovinAdImpl.getAdZone().e(), hashMap);
            CollectionUtils.putStringIfValid("clcode", appLovinAdImpl.getClCode(), hashMap);
            CollectionUtils.putStringIfValid("dsp_id", appLovinAdImpl.getDspId(), hashMap);
            CollectionUtils.putStringIfValid("dsp_name", appLovinAdImpl.getDspName(), hashMap);
            CollectionUtils.putStringIfValid("ad_size", appLovinAdImpl.getSize().getLabel(), hashMap);
            CollectionUtils.putStringIfValid("ad_event_id", appLovinAdImpl.getMediationServeId(), hashMap);
            CollectionUtils.putStringIfValid("is_omsdk_enabled", String.valueOf(appLovinAdImpl.isOpenMeasurementEnabled()), hashMap);
            if (appLovinAdImpl instanceof com.applovin.impl.sdk.ad.b) {
                CollectionUtils.putStringIfValid("is_persisted_ad", String.valueOf(((com.applovin.impl.sdk.ad.b) appLovinAdImpl).K0()), hashMap);
            }
        }
        return hashMap;
    }

    public static String b(com.applovin.impl.sdk.ad.b bVar) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, "reshow_count", bVar.b0());
        return jSONObject.toString();
    }

    public static Map a(com.applovin.impl.sdk.ad.b bVar) {
        HashMap hashMap = new HashMap();
        if (bVar != null) {
            com.applovin.impl.sdk.k sdk = bVar.getSdk();
            if (((Boolean) sdk.a(v4.J)).booleanValue()) {
                HashMap hashMap2 = new HashMap();
                Iterator it = bVar.l().iterator();
                while (it.hasNext()) {
                    String path = ((Uri) it.next()).getPath();
                    hashMap2.put(path, Formatter.formatFileSize(com.applovin.impl.sdk.k.o(), new File(path).length()));
                }
                hashMap.put("path", hashMap2.toString());
            }
            if ((bVar instanceof com.applovin.impl.sdk.ad.a) && ((Boolean) sdk.a(v4.K)).booleanValue()) {
                hashMap.put("details", ((com.applovin.impl.sdk.ad.a) bVar).s1());
            }
        }
        return hashMap;
    }

    public static Map a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        HashMap hashMap = new HashMap(7);
        if (appLovinNativeAdImpl == null) {
            return hashMap;
        }
        CollectionUtils.putStringIfValid("ad_domain", appLovinNativeAdImpl.getAdDomain(), hashMap);
        CollectionUtils.putStringIfValid("ad_id", String.valueOf(appLovinNativeAdImpl.getAdIdNumber()), hashMap);
        CollectionUtils.putStringIfValid("clcode", appLovinNativeAdImpl.getClCode(), hashMap);
        CollectionUtils.putStringIfValid("dsp_id", appLovinNativeAdImpl.getDspId(), hashMap);
        CollectionUtils.putStringIfValid("dsp_name", appLovinNativeAdImpl.getDspName(), hashMap);
        CollectionUtils.putStringIfValid("ad_size", AppLovinAdSize.NATIVE.toString(), hashMap);
        CollectionUtils.putStringIfValid("ad_event_id", appLovinNativeAdImpl.getMediationServeId(), hashMap);
        CollectionUtils.putStringIfValid("is_omsdk_enabled", String.valueOf(appLovinNativeAdImpl.isOpenMeasurementEnabled()), hashMap);
        return hashMap;
    }

    public static Map a(v2 v2Var) {
        Map a2 = a((h3) v2Var);
        CollectionUtils.putStringIfValid("bcode", v2Var.C(), a2);
        CollectionUtils.putStringIfValid(CampaignEx.JSON_KEY_CREATIVE_ID, v2Var.getCreativeId(), a2);
        CollectionUtils.putStringIfValid("ad_unit_id", v2Var.getAdUnitId(), a2);
        CollectionUtils.putStringIfValid("ad_event_id", v2Var.P(), a2);
        CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, v2Var.getFormat().getLabel(), a2);
        CollectionUtils.putStringIfValid("dsp_id", v2Var.getDspId(), a2);
        CollectionUtils.putStringIfValid("dsp_name", v2Var.getDspName(), a2);
        return a2;
    }

    public static Map a(h3 h3Var) {
        HashMap hashMap = new HashMap(3);
        CollectionUtils.putStringIfValid("network_name", h3Var.c(), hashMap);
        String b = h3Var.b();
        CollectionUtils.putStringIfValid("adapter_class", b, hashMap);
        CollectionUtils.putStringIfValid("adapter_version", t3.a(b).getAdapterVersion(), hashMap);
        return hashMap;
    }

    public static Map a(MaxError maxError) {
        HashMap hashMap = new HashMap(4);
        CollectionUtils.putStringIfValid("error_message", maxError.getMessage(), hashMap);
        CollectionUtils.putStringIfValid(AndroidBridgeConstants.ERROR_CODE, String.valueOf(maxError.getCode()), hashMap);
        CollectionUtils.putStringIfValid("mediated_network_error_message", maxError.getMediatedNetworkErrorMessage(), hashMap);
        CollectionUtils.putStringIfValid("mediated_network_error_code", String.valueOf(maxError.getMediatedNetworkErrorCode()), hashMap);
        return hashMap;
    }

    public static String a(String str) {
        return StringUtils.prefixToIndex(1000, str);
    }
}
