package com.ironsource.mediationsdk.adunit.adapter.internal.nativead;

import android.view.View;
import android.view.ViewGroup;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface;

/* loaded from: classes6.dex */
public interface AdapterNativeAdViewBinderInterface extends NativeAdViewBinderInterface {
    ViewGroup getNetworkNativeAdView();

    void setNativeAdView(View view);
}
