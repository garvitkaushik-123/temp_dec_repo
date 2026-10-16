package com.inmobi.media;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.x8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2939x8 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2752a;
    public final T7 b;
    public final InterfaceC2971z5 c;
    public final String d;
    public final D8 e;

    public C2939x8(Context context, AdConfig adConfig, T7 mNativeAdContainer, C2811p8 dataModel, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(mNativeAdContainer, "mNativeAdContainer");
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        this.b = mNativeAdContainer;
        this.c = interfaceC2971z5;
        this.d = "x8";
        D8 d8 = new D8(context, adConfig, mNativeAdContainer, dataModel, new C2923w8(this), new C2907v8(this), this, interfaceC2971z5);
        this.e = d8;
        D9 d9 = d8.m;
        int i = mNativeAdContainer.B;
        d9.getClass();
        D9.f = i;
    }

    public final J8 a(View view, ViewGroup parent, boolean z, GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        J8 j8;
        InterfaceC2971z5 interfaceC2971z5;
        Intrinsics.checkNotNullParameter(parent, "parent");
        KeyEvent.Callback findViewWithTag = view != null ? view.findViewWithTag("InMobiAdView") : null;
        J8 j82 = findViewWithTag instanceof J8 ? (J8) findViewWithTag : null;
        if (z) {
            j8 = this.e.a(j82, parent, gestureDetectorOnGestureListenerC2634ec);
        } else {
            D8 d8 = this.e;
            d8.getClass();
            Intrinsics.checkNotNullParameter(parent, "parent");
            d8.o = gestureDetectorOnGestureListenerC2634ec;
            J8 container = d8.a(j82, parent);
            if (!d8.n) {
                C2681h8 root = d8.c.e;
                if (container != null && root != null) {
                    Intrinsics.checkNotNullParameter(container, "container");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(root, "root");
                    d8.b((ViewGroup) container, root);
                }
            }
            j8 = container;
        }
        if (j82 == null && (interfaceC2971z5 = this.c) != null) {
            String TAG = this.d;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).b(TAG, "InMobiNative.getPrimaryView called with Non Native View.");
        }
        if (j8 != null) {
            j8.setNativeStrandAd(this.b);
        }
        if (j8 == null) {
            return j8;
        }
        j8.setTag("InMobiAdView");
        return j8;
    }
}
