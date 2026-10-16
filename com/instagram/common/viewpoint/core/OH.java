package com.instagram.common.viewpoint.core;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.InterstitialAdListener;

/* loaded from: assets/audience_network/classes2.dex */
public class OH implements InterstitialAdListener {
    public final /* synthetic */ AbstractC2094jd A00;
    public final /* synthetic */ Cif A01;

    public OH(Cif cif, AbstractC2094jd abstractC2094jd) {
        this.A01 = cif;
        this.A00 = abstractC2094jd;
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdClicked(Ad ad) {
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdLoaded(Ad ad) {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C2039iY c2039iY;
        interstitialAdExtendedListener = this.A01.A00.A07;
        c2039iY = this.A01.A00.A08;
        interstitialAdExtendedListener.onAdLoaded(c2039iY.A6k());
    }

    @Override // com.facebook.ads.AdListener
    public final void onError(Ad ad, AdError adError) {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C2039iY c2039iY;
        this.A01.A00.A01 = null;
        this.A00.A2J(false);
        interstitialAdExtendedListener = this.A01.A00.A07;
        c2039iY = this.A01.A00.A08;
        interstitialAdExtendedListener.onAdLoaded(c2039iY.A6k());
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public final void onInterstitialDismissed(Ad ad) {
        C08027j c08027j;
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C2039iY c2039iY;
        C08027j c08027j2;
        C08027j c08027j3;
        C08027j c08027j4;
        this.A01.A00.A04 = false;
        c08027j = this.A01.A00.A03;
        if (c08027j != null) {
            c08027j2 = this.A01.A00.A03;
            c08027j2.A0S(new C2046ih(this));
            c08027j3 = this.A01.A00.A03;
            c08027j3.A0N();
            c08027j4 = this.A01.A00.A03;
            c08027j4.A0K();
            this.A01.A00.A03 = null;
        }
        interstitialAdExtendedListener = this.A01.A00.A07;
        c2039iY = this.A01.A00.A08;
        interstitialAdExtendedListener.onInterstitialDismissed(c2039iY.A6k());
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public final void onInterstitialDisplayed(Ad ad) {
    }

    @Override // com.facebook.ads.AdListener
    public final void onLoggingImpression(Ad ad) {
    }
}
