package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.bf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2586bf extends Xe {
    public final T7 e;
    public GestureDetectorOnGestureListenerC2634ec f;
    public final InterfaceC2971z5 g;
    public final String h;
    public boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2586bf(T7 mNativeAdContainer, GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec, InterfaceC2971z5 interfaceC2971z5) {
        super(mNativeAdContainer);
        Intrinsics.checkNotNullParameter(mNativeAdContainer, "mNativeAdContainer");
        this.e = mNativeAdContainer;
        this.f = gestureDetectorOnGestureListenerC2634ec;
        this.g = interfaceC2971z5;
        this.h = "InMobi";
    }

    @Override // com.inmobi.media.Xe
    public final void a(byte b) {
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
    }

    @Override // com.inmobi.media.Xe
    public final void a(Map map) {
    }

    @Override // com.inmobi.media.Xe
    public final void e() {
    }

    @Override // com.inmobi.media.Xe
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
    }

    @Override // com.inmobi.media.Xe
    public final View a(View view, ViewGroup parent, boolean z) {
        Context j;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.i || (j = this.e.j()) == null) {
            return null;
        }
        AdConfig adConfig = this.d;
        T7 t7 = this.e;
        C2811p8 c2811p8 = t7.b;
        Intrinsics.checkNotNull(c2811p8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeDataModel");
        this.b = new C2939x8(j, adConfig, t7, c2811p8, this.g);
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b(this.h, "Ad markup loaded into the container will be inflated into a View.");
        }
        C2939x8 c2939x8 = this.b;
        this.c = new WeakReference(c2939x8 != null ? c2939x8.a(view, parent, z, this.f) : null);
        T7 t72 = this.e;
        t72.getClass();
        D4.a(new J7(t72, t72), "EndCardBuilderTask");
        return b();
    }

    @Override // com.inmobi.media.Xe
    public final void a() {
        if (this.i) {
            return;
        }
        this.i = true;
        C2939x8 c2939x8 = this.b;
        if (c2939x8 != null) {
            D8 d8 = c2939x8.e;
            d8.n = true;
            d8.i.clear();
            d8.p = null;
            L8 l8 = d8.j;
            if (l8 != null) {
                l8.destroy();
            }
            d8.j = null;
            if (!c2939x8.f2752a) {
                c2939x8.f2752a = true;
            }
        }
        this.b = null;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f;
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            gestureDetectorOnGestureListenerC2634ec.b();
        }
        this.f = null;
        super.a();
    }
}
