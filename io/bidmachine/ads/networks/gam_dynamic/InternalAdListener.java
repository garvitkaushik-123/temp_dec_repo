package io.bidmachine.ads.networks.gam_dynamic;

/* loaded from: classes7.dex */
public interface InternalAdListener {
    void onAdDestroyed(InternalAd internalAd, boolean isAdReleased);

    void onAdExpired(InternalAd internalAd);

    void onAdShown(InternalAd internalAd);

    void onPaidEvent(InternalAd internalAd);
}
