package com.ironsource.adapters.admob.nativead;

import com.google.android.gms.ads.nativead.NativeAd;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.logger.IronLog;

/* loaded from: classes6.dex */
public class AdMobNativeAdData extends AdapterNativeAdData {
    private NativeAd mNativeAd;

    public AdMobNativeAdData(NativeAd nativeAd) {
        this.mNativeAd = nativeAd;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getTitle() {
        IronLog.ADAPTER_CALLBACK.verbose("headline = " + this.mNativeAd.getHeadline());
        return this.mNativeAd.getHeadline();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getAdvertiser() {
        IronLog.ADAPTER_CALLBACK.verbose("advertiser = " + this.mNativeAd.getAdvertiser());
        return this.mNativeAd.getAdvertiser();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getBody() {
        IronLog.ADAPTER_CALLBACK.verbose("body = " + this.mNativeAd.getBody());
        return this.mNativeAd.getBody();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getCallToAction() {
        IronLog.ADAPTER_CALLBACK.verbose("cta = " + this.mNativeAd.getCallToAction());
        return this.mNativeAd.getCallToAction();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public NativeAdDataInterface.Image getIcon() {
        NativeAd.Image icon = this.mNativeAd.getIcon();
        if (icon == null) {
            return null;
        }
        IronLog.ADAPTER_CALLBACK.verbose("icon uri = " + icon.getUri());
        return new NativeAdDataInterface.Image(icon.getDrawable(), icon.getUri());
    }
}
