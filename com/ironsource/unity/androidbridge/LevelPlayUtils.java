package com.ironsource.unity.androidbridge;

import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.controller.f;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.LevelPlayAdSize;
import com.unity3d.mediation.LevelPlayConfiguration;
import com.unity3d.mediation.LevelPlayInitError;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class LevelPlayUtils {
    LevelPlayUtils() {
    }

    public static String adInfoToString(LevelPlayAdInfo levelPlayAdInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f.b.c, levelPlayAdInfo.getAdId());
            jSONObject.put("adUnitId", levelPlayAdInfo.getAdUnitId());
            jSONObject.put("adUnitName", levelPlayAdInfo.getAdUnitName());
            jSONObject.put(C3040d4.h.O, adSizeToString(levelPlayAdInfo.getAdSize()));
            jSONObject.put("adFormat", levelPlayAdInfo.getAdFormat());
            jSONObject.put("placementName", levelPlayAdInfo.getPlacementName());
            jSONObject.put("auctionId", levelPlayAdInfo.getAuctionId());
            jSONObject.put("country", levelPlayAdInfo.getCountry());
            jSONObject.put("ab", levelPlayAdInfo.getAb());
            jSONObject.put("segmentName", levelPlayAdInfo.getSegmentName());
            jSONObject.put("adNetwork", levelPlayAdInfo.getAdNetwork());
            jSONObject.put("instanceName", levelPlayAdInfo.getInstanceName());
            jSONObject.put("instanceId", levelPlayAdInfo.getInstanceId());
            jSONObject.put("revenue", levelPlayAdInfo.getRevenue());
            jSONObject.put("precision", levelPlayAdInfo.getPrecision());
            jSONObject.put("encryptedCPM", levelPlayAdInfo.getEncryptedCPM());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String configurationToString(LevelPlayConfiguration levelPlayConfiguration) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isAdQualityEnabled", levelPlayConfiguration.isAdQualityEnabled());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String initErrorToString(LevelPlayInitError levelPlayInitError) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, levelPlayInitError.getErrorCode());
            jSONObject.put("errorMessage", levelPlayInitError.getErrorMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String adErrorToString(LevelPlayAdError levelPlayAdError) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, levelPlayAdError.getErrorCode());
            jSONObject.put("errorMessage", levelPlayAdError.getErrorMessage());
            jSONObject.put("adUnitId", levelPlayAdError.getAdUnitId());
            jSONObject.put(f.b.c, levelPlayAdError.getAdId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static String adSizeToString(LevelPlayAdSize levelPlayAdSize) {
        if (levelPlayAdSize == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("description", levelPlayAdSize.getDescription());
            jSONObject.put("width", levelPlayAdSize.getWidth());
            jSONObject.put("height", levelPlayAdSize.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
