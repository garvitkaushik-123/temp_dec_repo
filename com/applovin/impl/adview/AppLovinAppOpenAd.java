package com.applovin.impl.adview;

import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

/* loaded from: classes2.dex */
public class AppLovinAppOpenAd {

    /* renamed from: a, reason: collision with root package name */
    private final AppLovinInterstitialAdDialog f366a = AppLovinInterstitialAd.create();

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f366a.setAdClickListener(appLovinAdClickListener);
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f366a.setAdDisplayListener(appLovinAdDisplayListener);
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f366a.setAdVideoPlaybackListener(appLovinAdVideoPlaybackListener);
    }

    public void show(AppLovinAd appLovinAd) {
        this.f366a.showAndRender(appLovinAd);
    }

    public String toString() {
        return "AppLovinAppOpenAd{}";
    }
}
