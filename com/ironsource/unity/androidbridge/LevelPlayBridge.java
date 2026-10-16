package com.ironsource.unity.androidbridge;

import com.ironsource.mediationsdk.config.ConfigFile;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayConfiguration;
import com.unity3d.mediation.LevelPlayInitError;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.LevelPlayInitRequest;
import com.unity3d.mediation.impression.LevelPlayImpressionData;
import com.unity3d.mediation.impression.LevelPlayImpressionDataListener;
import com.unity3d.mediation.segment.LevelPlaySegment;
import com.unity3d.player.UnityPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class LevelPlayBridge implements LevelPlayInitListener, LevelPlayImpressionDataListener {
    private static final LevelPlayBridge mInstance = new LevelPlayBridge();
    private UnityImpressionDataListener mUnityImpressionDataListener;
    private IUnityLevelPlayInitListener mUnityLevelPlayInitListener;

    private LevelPlayBridge() {
    }

    public static synchronized LevelPlayBridge getInstance() {
        LevelPlayBridge levelPlayBridge;
        synchronized (LevelPlayBridge.class) {
            levelPlayBridge = mInstance;
        }
        return levelPlayBridge;
    }

    public void initialize(String str, String str2, String[] strArr, IUnityLevelPlayInitListener iUnityLevelPlayInitListener) {
        List<LevelPlay.AdFormat> adFormatList = getAdFormatList(strArr);
        LevelPlayInitRequest.Builder builder = new LevelPlayInitRequest.Builder(str);
        if (str2 != null && str2 != "") {
            builder.withUserId(str2);
        }
        if (adFormatList != null) {
            builder.withLegacyAdFormats(adFormatList);
        }
        LevelPlayInitRequest build = builder.build();
        this.mUnityLevelPlayInitListener = iUnityLevelPlayInitListener;
        LevelPlay.init(UnityPlayer.currentActivity, build, this);
    }

    public void setPluginData(String str, String str2, String str3) {
        ConfigFile.getConfigFile().setPluginData(str, str2, str3);
    }

    public boolean setDynamicUserId(String str) {
        return LevelPlay.setDynamicUserId(str);
    }

    public void setUnityImpressionDataListener(UnityImpressionDataListener unityImpressionDataListener) {
        this.mUnityImpressionDataListener = unityImpressionDataListener;
    }

    public void validateIntegration() {
        LevelPlay.validateIntegration(UnityPlayer.currentActivity);
    }

    public void launchTestSuite() {
        LevelPlay.launchTestSuite(UnityPlayer.currentActivity);
    }

    public void setNetworkData(String str, String str2) {
        try {
            LevelPlay.setNetworkData(str, new JSONObject(str2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAdaptersDebug(boolean z) {
        LevelPlay.setAdaptersDebug(z);
    }

    public void setMetaData(String str, String str2) {
        LevelPlay.setMetaData(str, str2);
    }

    public void setMetaData(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            arrayList.add(str2);
        }
        LevelPlay.setMetaData(str, arrayList);
    }

    public void setConsent(boolean z) {
        LevelPlay.setConsent(z);
    }

    public void setSegment(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            LevelPlaySegment levelPlaySegment = new LevelPlaySegment();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equals("level")) {
                    levelPlaySegment.setLevel(jSONObject.optInt(next));
                } else if (next.equals(AndroidBridgeConstants.SEGMENT_PAYING)) {
                    levelPlaySegment.setPaying(jSONObject.optInt(next) != 0);
                } else if (next.equals(AndroidBridgeConstants.SEGMENT_CREATION_DATE)) {
                    levelPlaySegment.setUserCreationDate(jSONObject.optLong(next));
                } else if (next.equals("segmentName")) {
                    levelPlaySegment.setSegmentName(jSONObject.optString(next));
                } else if (next.equals("iapt")) {
                    levelPlaySegment.setIapTotal(jSONObject.optDouble(next));
                } else {
                    levelPlaySegment.setCustom(next, jSONObject.optString(next));
                }
            }
            LevelPlay.setSegment(levelPlaySegment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.unity3d.mediation.LevelPlayInitListener
    public void onInitFailed(final LevelPlayInitError levelPlayInitError) {
        if (this.mUnityLevelPlayInitListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayBridge.1
                @Override // java.lang.Runnable
                public void run() {
                    LevelPlayBridge.this.mUnityLevelPlayInitListener.onInitFailed(LevelPlayUtils.initErrorToString(levelPlayInitError));
                }
            });
        }
    }

    @Override // com.unity3d.mediation.LevelPlayInitListener
    public void onInitSuccess(final LevelPlayConfiguration levelPlayConfiguration) {
        LevelPlay.addImpressionDataListener(this);
        AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayBridge.2
            @Override // java.lang.Runnable
            public void run() {
                if (LevelPlayBridge.this.mUnityLevelPlayInitListener != null) {
                    LevelPlayBridge.this.mUnityLevelPlayInitListener.onInitSuccess(LevelPlayUtils.configurationToString(levelPlayConfiguration));
                }
            }
        });
    }

    @Override // com.unity3d.mediation.impression.LevelPlayImpressionDataListener
    public void onImpressionSuccess(final LevelPlayImpressionData levelPlayImpressionData) {
        AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayBridge.3
            @Override // java.lang.Runnable
            public void run() {
                if (LevelPlayBridge.this.mUnityImpressionDataListener != null) {
                    LevelPlayBridge.this.mUnityImpressionDataListener.onImpressionSuccess(AndroidBridgeUtilities.getImpressionDataString(levelPlayImpressionData));
                }
            }
        });
    }

    private List<LevelPlay.AdFormat> getAdFormatList(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(LevelPlay.AdFormat.valueOf(str.toUpperCase()));
        }
        return arrayList;
    }
}
