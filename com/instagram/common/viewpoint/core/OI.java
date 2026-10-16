package com.instagram.common.viewpoint.core;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;

/* loaded from: assets/audience_network/classes2.dex */
public class OI implements RewardedVideoAdListener {
    public final /* synthetic */ C2042ib A00;

    public OI(C2042ib c2042ib) {
        this.A00 = c2042ib;
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdClicked(Ad ad) {
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdLoaded(Ad ad) {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2024iI c2024iI;
        s2SRewardedVideoAdExtendedListener = this.A00.A00.A07;
        c2024iI = this.A00.A00.A08;
        s2SRewardedVideoAdExtendedListener.onAdLoaded(c2024iI.A6k());
    }

    @Override // com.facebook.ads.AdListener
    public final void onError(Ad ad, AdError adError) {
        NQ nq;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2024iI c2024iI;
        this.A00.A00.A02 = null;
        nq = this.A00.A00.A03;
        ((AbstractC2094jd) nq).A2J(false);
        s2SRewardedVideoAdExtendedListener = this.A00.A00.A07;
        c2024iI = this.A00.A00.A08;
        s2SRewardedVideoAdExtendedListener.onAdLoaded(c2024iI.A6k());
    }

    @Override // com.facebook.ads.AdListener
    public final void onLoggingImpression(Ad ad) {
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public final void onRewardedVideoClosed() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A00.A07;
        s2SRewardedVideoAdExtendedListener.onRewardedVideoClosed();
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public final void onRewardedVideoCompleted() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A00.A07;
        s2SRewardedVideoAdExtendedListener.onRewardedVideoCompleted();
    }
}
