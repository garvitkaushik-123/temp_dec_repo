package io.bidmachine;

import io.bidmachine.IAd;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public interface AdListener<AdType extends IAd> {
    void onAdClicked(AdType ad);

    void onAdExpired(AdType ad);

    void onAdImpression(AdType ad);

    void onAdLoadFailed(AdType ad, BMError error);

    void onAdLoaded(AdType ad);

    void onAdShowFailed(AdType ad, BMError error);
}
