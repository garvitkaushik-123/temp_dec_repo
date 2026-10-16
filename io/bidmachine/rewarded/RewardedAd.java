package io.bidmachine.rewarded;

import android.content.Context;
import io.bidmachine.AdProcessCallback;
import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.FullScreenAd;
import io.bidmachine.FullScreenAdObject;
import io.bidmachine.NetworkAdapter;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedFullscreenAd;

/* loaded from: classes8.dex */
public final class RewardedAd extends FullScreenAd<RewardedAd, RewardedRequest, FullScreenAdObject<RewardedRequest>, RewardedListener> {
    public RewardedAd(Context context) {
        super(context, AdsType.Rewarded);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.BidMachineAd
    public FullScreenAdObject<RewardedRequest> createAdObject(ContextProvider contextProvider, RewardedRequest adRequest, NetworkAdapter adapter, AdObjectParams adObjectParams, AdProcessCallback processCallback) {
        UnifiedFullscreenAd createRewarded = adapter.createRewarded();
        if (createRewarded == null) {
            return null;
        }
        return new FullScreenAdObject<>(contextProvider, processCallback, adRequest, adObjectParams, createRewarded);
    }
}
