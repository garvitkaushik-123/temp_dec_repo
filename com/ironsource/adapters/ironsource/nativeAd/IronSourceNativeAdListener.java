package com.ironsource.adapters.ironsource.nativeAd;

import com.ironsource.B8;
import com.ironsource.D8;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class IronSourceNativeAdListener implements D8.a {
    private final IronSourceNativeAdViewBinder binder;
    private final NativeAdSmashListener smashListener;

    public IronSourceNativeAdListener(IronSourceNativeAdViewBinder binder, NativeAdSmashListener smashListener) {
        Intrinsics.checkNotNullParameter(binder, "binder");
        Intrinsics.checkNotNullParameter(smashListener, "smashListener");
        this.binder = binder;
        this.smashListener = smashListener;
    }

    @Override // com.ironsource.D8.a
    public void onNativeAdClicked() {
        this.smashListener.onNativeAdClicked();
    }

    @Override // com.ironsource.D8.a
    public void onNativeAdLoadFailed(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.smashListener.onNativeAdLoadFailed(new IronSourceError(510, "Load failed - " + reason));
    }

    @Override // com.ironsource.D8.a
    public void onNativeAdLoadSuccess(B8 adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        this.smashListener.onNativeAdLoaded(new IronSourceNativeAdData(adData), this.binder);
    }

    @Override // com.ironsource.D8.a
    public void onNativeAdShown() {
        this.smashListener.onNativeAdShown();
    }
}
