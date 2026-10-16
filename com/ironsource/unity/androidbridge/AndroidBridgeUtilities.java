package com.ironsource.unity.androidbridge;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.impression.LevelPlayImpressionData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class AndroidBridgeUtilities {
    private static final ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();

    public static HashMap<String, String> getHashMapFromJsonString(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static String parseErrorToEvent(int i, String str) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(AndroidBridgeConstants.ERROR_CODE, String.valueOf(i));
            hashMap.put("error_description", str);
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String parseIronSourceError(IronSourceError ironSourceError) {
        if (ironSourceError != null) {
            return parseErrorToEvent(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
        return "";
    }

    public static String getPlacememtJson(Placement placement) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(AndroidBridgeConstants.PLACEMENT_ID, String.valueOf(placement.getPlacementId()));
            hashMap.put(AndroidBridgeConstants.PLACEMENT_NAME, placement.getPlacementName());
            hashMap.put(AndroidBridgeConstants.PLACEMENT_REWARDED_AMOUNT, String.valueOf(placement.getRewardAmount()));
            hashMap.put(AndroidBridgeConstants.PLACEMENT_REWARDED_NAME, placement.getRewardName());
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAdInfoString(AdInfo adInfo) {
        return adInfo == null ? "" : adInfo.toString();
    }

    public static String getImpressionDataString(ImpressionData impressionData) {
        return impressionData == null ? "" : impressionData.getAllData().toString();
    }

    public static String getImpressionDataString(LevelPlayImpressionData levelPlayImpressionData) {
        return levelPlayImpressionData == null ? "" : levelPlayImpressionData.getAllData().toString();
    }

    public static void postBackgroundTask(Runnable runnable) {
        ExecutorService executorService = callbackExecutor;
        if (executorService.isShutdown()) {
            return;
        }
        executorService.submit(runnable);
    }
}
