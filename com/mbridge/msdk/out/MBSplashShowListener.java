package com.mbridge.msdk.out;

/* loaded from: classes6.dex */
public interface MBSplashShowListener {
    void onAdClicked(MBridgeIds mBridgeIds);

    void onAdTick(MBridgeIds mBridgeIds, long j);

    void onDismiss(MBridgeIds mBridgeIds, int i);

    void onShowFailed(MBridgeIds mBridgeIds, String str);

    void onShowSuccessed(MBridgeIds mBridgeIds);

    void onZoomOutPlayFinish(MBridgeIds mBridgeIds);

    void onZoomOutPlayStart(MBridgeIds mBridgeIds);
}
