package com.mbridge.msdk.out;

import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.util.a;

/* loaded from: classes6.dex */
public abstract class NativeAdWithCodeListener implements NativeListener.NativeAdListener {
    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdLoadError(String str) {
        onAdLoadErrorWithCode(a.a(1000, str), str);
    }

    public abstract void onAdLoadErrorWithCode(int i, String str);
}
