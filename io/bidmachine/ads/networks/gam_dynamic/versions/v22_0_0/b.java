package io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAdPresentListener;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class b extends FullScreenContentCallback {

    /* renamed from: a, reason: collision with root package name */
    private final InternalFullscreenAdPresentListener f6627a;

    b(InternalFullscreenAdPresentListener adListener) {
        this.f6627a = adListener;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public void onAdClicked() {
        this.f6627a.onAdClicked();
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public void onAdDismissedFullScreenContent() {
        this.f6627a.onAdComplete();
        this.f6627a.onAdClosed();
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public void onAdFailedToShowFullScreenContent(AdError adError) {
        this.f6627a.onAdShowFailed(e.a(BMError.InternalUnknownError, adError));
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public void onAdImpression() {
        this.f6627a.onAdShown();
    }
}
