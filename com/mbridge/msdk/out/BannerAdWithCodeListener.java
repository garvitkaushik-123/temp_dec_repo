package com.mbridge.msdk.out;

import com.mbridge.msdk.util.a;

/* loaded from: classes6.dex */
public abstract class BannerAdWithCodeListener implements BannerAdListener {
    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
        onLoadFailedWithCode(mBridgeIds, a.a(2000, str), str);
    }

    public abstract void onLoadFailedWithCode(MBridgeIds mBridgeIds, int i, String str);
}
