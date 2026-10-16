package io.bidmachine.ads.networks.gam.versions.v21_0_0;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import io.bidmachine.ads.networks.gam.InternalGAMFullscreenAdPresentListener;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class b extends FullScreenContentCallback {

    /* renamed from: a, reason: collision with root package name */
    private final InternalGAMFullscreenAdPresentListener f6589a;

    b(InternalGAMFullscreenAdPresentListener adListener) {
        this.f6589a = adListener;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public void onAdClicked() {
        this.f6589a.onAdClicked();
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public void onAdDismissedFullScreenContent() {
        this.f6589a.onAdComplete();
        this.f6589a.onAdClosed();
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public void onAdFailedToShowFullScreenContent(AdError adError) {
        this.f6589a.onAdShowFailed(new BMError(BMError.InternalUnknownError, adError.getCode(), adError.getMessage()));
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public void onAdImpression() {
        this.f6589a.onAdShown();
    }
}
