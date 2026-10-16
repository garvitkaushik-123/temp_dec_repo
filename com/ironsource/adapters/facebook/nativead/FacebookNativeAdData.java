package com.ironsource.adapters.facebook.nativead;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.ads.NativeAd;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.logger.IronLog;

/* loaded from: classes6.dex */
public class FacebookNativeAdData extends AdapterNativeAdData {
    private Drawable mIconDrawable;
    private final NativeAd mNativeAd;

    protected FacebookNativeAdData(NativeAd nativeAd, Drawable drawable) {
        this.mNativeAd = nativeAd;
        this.mIconDrawable = drawable;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getTitle() {
        IronLog.ADAPTER_CALLBACK.verbose("headline = " + this.mNativeAd.getAdHeadline());
        return this.mNativeAd.getAdHeadline();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getAdvertiser() {
        IronLog.ADAPTER_CALLBACK.verbose("advertiser = " + this.mNativeAd.getAdvertiserName());
        return this.mNativeAd.getAdvertiserName();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getBody() {
        IronLog.ADAPTER_CALLBACK.verbose("body = " + this.mNativeAd.getAdBodyText());
        return this.mNativeAd.getAdBodyText();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getCallToAction() {
        IronLog.ADAPTER_CALLBACK.verbose("cta = " + this.mNativeAd.getAdCallToAction());
        return this.mNativeAd.getAdCallToAction();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public NativeAdDataInterface.Image getIcon() {
        Uri parse = this.mNativeAd.getAdIcon() != null ? Uri.parse(this.mNativeAd.getAdIcon().getUrl()) : null;
        IronLog.ADAPTER_CALLBACK.verbose("icon uri = " + parse);
        if (this.mNativeAd.getPreloadedIconViewDrawable() != null) {
            this.mIconDrawable = this.mNativeAd.getPreloadedIconViewDrawable();
        }
        return new NativeAdDataInterface.Image(this.mIconDrawable, parse);
    }
}
