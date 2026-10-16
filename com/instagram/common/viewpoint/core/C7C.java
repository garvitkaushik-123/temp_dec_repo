package com.instagram.common.viewpoint.core;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* renamed from: com.facebook.ads.redexgen.X.7C, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C7C extends C1958hB {
    public InterfaceC1801ee A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A08(NativeAdLayout nativeAdLayout, C1929gi c1929gi, NativeAd nativeAd, C1393Vd c1393Vd) {
        C1623bk c1623bk = new C1623bk(c1929gi);
        MediaView mediaView = new MediaView(c1929gi);
        AdOptionsView adOptionsView = new AdOptionsView(c1929gi, nativeAd, nativeAdLayout);
        c1393Vd.A09(adOptionsView, 28);
        this.A00 = new F2(c1929gi, nativeAd, c1393Vd, UK.A0L(nativeAd.getInternalNativeAd()).A1C(), c1623bk, mediaView, adOptionsView);
        YB.A0N(nativeAdLayout, c1393Vd.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, c1623bk, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.instagram.common.viewpoint.core.C1299Rm, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
