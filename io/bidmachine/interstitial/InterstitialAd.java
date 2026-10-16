package io.bidmachine.interstitial;

import android.content.Context;
import io.bidmachine.AdProcessCallback;
import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.FullScreenAd;
import io.bidmachine.FullScreenAdObject;
import io.bidmachine.NetworkAdapter;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedFullscreenAd;

/* loaded from: classes7.dex */
public final class InterstitialAd extends FullScreenAd<InterstitialAd, InterstitialRequest, FullScreenAdObject<InterstitialRequest>, InterstitialListener> {
    public InterstitialAd(Context context) {
        super(context, AdsType.Interstitial);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.BidMachineAd
    public FullScreenAdObject<InterstitialRequest> createAdObject(ContextProvider contextProvider, InterstitialRequest adRequest, NetworkAdapter adapter, AdObjectParams adObjectParams, AdProcessCallback processCallback) {
        UnifiedFullscreenAd createInterstitial = adapter.createInterstitial();
        if (createInterstitial == null) {
            return null;
        }
        return new FullScreenAdObject<>(contextProvider, processCallback, adRequest, adObjectParams, createInterstitial);
    }
}
