package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public interface InternalAdPresentListener {
    void onAdClicked();

    void onAdExpired();

    void onAdShowFailed(BMError bmError);

    void onAdShown();
}
