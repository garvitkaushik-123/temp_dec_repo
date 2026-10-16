package com.ironsource;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Hb extends K0 {

    /* renamed from: a, reason: collision with root package name */
    private final InternalNativeAdListener f2899a;

    public Hb(InternalNativeAdListener mNativeAdListener) {
        Intrinsics.checkNotNullParameter(mNativeAdListener, "mNativeAdListener");
        this.f2899a = mNativeAdListener;
    }

    @Override // com.ironsource.K0
    public void a(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(nativeAdViewBinder, "nativeAdViewBinder");
        this.f2899a.onNativeAdLoaded(adInfo, adapterNativeAdData, nativeAdViewBinder);
    }

    @Override // com.ironsource.K0
    public void d(AdInfo adInfo) {
        this.f2899a.onNativeAdImpression(adInfo);
    }

    @Override // com.ironsource.K0
    public void a(IronSourceError ironSourceError) {
        this.f2899a.onNativeAdLoadFailed(ironSourceError);
    }

    @Override // com.ironsource.K0
    public void a(Placement placement, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.f2899a.onNativeAdClicked(adInfo);
    }
}
