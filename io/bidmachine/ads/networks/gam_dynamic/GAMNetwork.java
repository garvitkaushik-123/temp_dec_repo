package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import io.bidmachine.AdsFormat;
import io.bidmachine.NetworkAdUnit;

/* loaded from: classes7.dex */
interface GAMNetwork {
    void cache();

    void cache(AdsFormat adsFormat);

    boolean cacheWaterfall(AdsFormat adsFormat, boolean isForced);

    String getVersion();

    void init(Context context);

    boolean isInitialized();

    void loadBanner(NetworkAdUnit networkAdUnit, InternalBannerAdListener gamListener);

    void loadInterstitial(NetworkAdUnit networkAdUnit, InternalInterstitialAdListener gamListener);

    void loadRewarded(NetworkAdUnit networkAdUnit, InternalRewardedAdListener gamListener);

    InternalAdData reserveMostExpensiveAd(NetworkAdUnit networkAdUnit, AdsFormat adsFormat);

    void unReserveAd(NetworkAdUnit networkAdUnit);
}
