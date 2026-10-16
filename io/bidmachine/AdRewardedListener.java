package io.bidmachine;

import io.bidmachine.IAd;

/* loaded from: classes7.dex */
public interface AdRewardedListener<AdType extends IAd> {
    void onAdRewarded(AdType ad);
}
