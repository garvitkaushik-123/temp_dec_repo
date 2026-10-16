package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;
import com.facebook.ads.internal.api.NativeAdLayoutApi;
import com.facebook.ads.internal.api.NativeBannerAdViewApi;

/* loaded from: assets/audience_network/classes2.dex */
public final class SB implements NativeBannerAdViewApi {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.ads.internal.api.NativeAdLayoutApi, com.facebook.ads.redexgen.X.7L] */
    public static View A00(C1929gi c1929gi, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        UK.A0L(nativeBannerAd.getInternalNativeAd()).A1h(EnumC1394Ve.A00(type.getEnumCode()));
        ?? r1 = new C1958hB() { // from class: com.facebook.ads.redexgen.X.7L
            public InterfaceC1801ee A00;

            /* JADX WARN: Failed to parse debug info
            java.lang.ArrayIndexOutOfBoundsException
             */
            public final void A08(C1929gi c1929gi2, NativeBannerAd nativeBannerAd2, C1393Vd c1393Vd, NativeAdLayout nativeAdLayout) {
                MediaView mediaView = new MediaView(nativeAdLayout.getContext());
                AdOptionsView adOptionsView = new AdOptionsView(nativeAdLayout.getContext(), nativeBannerAd2, nativeAdLayout);
                c1393Vd.A09(adOptionsView, 20);
                UK A0L = UK.A0L(nativeBannerAd2.getInternalNativeAd());
                EnumC1394Ve A1C = A0L.A1C();
                A0L.A1m(true);
                this.A00 = new F7(c1929gi2, nativeBannerAd2, c1393Vd, A1C, mediaView, adOptionsView, A0L.A1F());
                YB.A0N(nativeAdLayout, c1393Vd.A00());
                nativeBannerAd2.registerViewForInteraction(nativeAdLayout, mediaView, this.A00.getViewsForInteraction());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                nativeAdLayout.addView(this.A00.getView(), layoutParams);
            }

            @Override // com.instagram.common.viewpoint.core.C1299Rm, com.facebook.ads.internal.api.AdComponentViewParentApi
            public final void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                this.A00.unregisterView();
            }
        };
        NativeAdLayout nativeAdLayout = new NativeAdLayout(c1929gi, (NativeAdLayoutApi) r1);
        r1.A08(c1929gi, nativeBannerAd, (C1393Vd) nativeAdViewAttributes.getInternalAttributes(), nativeAdLayout);
        nativeAdLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (XX.A02 * type.getHeight())));
        return nativeAdLayout;
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdViewApi
    public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type) {
        return render(context, nativeBannerAd, type, null);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdViewApi
    public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        try {
            return A00(C1302Rp.A03(context), nativeBannerAd, type, nativeAdViewAttributes);
        } catch (Throwable th) {
            return Z4.A00(C1302Rp.A03(context), th);
        }
    }
}
