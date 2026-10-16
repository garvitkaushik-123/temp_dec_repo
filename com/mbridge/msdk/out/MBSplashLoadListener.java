package com.mbridge.msdk.out;

/* loaded from: classes6.dex */
public interface MBSplashLoadListener {
    void isSupportZoomOut(MBridgeIds mBridgeIds, boolean z);

    void onLoadFailed(MBridgeIds mBridgeIds, String str, int i);

    void onLoadSuccessed(MBridgeIds mBridgeIds, int i);
}
