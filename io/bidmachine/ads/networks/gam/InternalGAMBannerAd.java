package io.bidmachine.ads.networks.gam;

import android.view.View;
import io.bidmachine.AdsFormat;

/* loaded from: classes7.dex */
public abstract class InternalGAMBannerAd extends InternalGAMAd {
    protected abstract View getAdView();

    public InternalGAMBannerAd(GAMLoader gamLoader, AdsFormat adsFormat, GAMUnitData gamUnitData) {
        super(gamLoader, adsFormat, gamUnitData);
    }
}
