package io.bidmachine.ads.networks.gam;

import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public interface InternalGAMAdPresentListener {
    void onAdClicked();

    void onAdExpired();

    void onAdShowFailed(BMError bmError);

    void onAdShown();
}
