package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.AdsFormat;
import io.bidmachine.protobuf.Waterfall;

/* loaded from: classes7.dex */
public abstract class InternalInterstitialAd extends InternalFullscreenAd {
    public InternalInterstitialAd(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener) {
        super(networkParams, taskExecutor, adsFormat, adUnit, internalAdListener);
    }
}
