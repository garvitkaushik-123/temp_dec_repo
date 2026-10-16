package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.cf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2603cf extends Xe {
    public final C2562a9 e;
    public final InterfaceC2971z5 f;
    public boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2603cf(C2562a9 mNativeVideoAdContainer, InterfaceC2971z5 interfaceC2971z5) {
        super(mNativeVideoAdContainer);
        Intrinsics.checkNotNullParameter(mNativeVideoAdContainer, "mNativeVideoAdContainer");
        this.e = mNativeVideoAdContainer;
        this.f = interfaceC2971z5;
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
        if (this.g || (j = this.e.j()) == null) {
            return null;
        }
        AdConfig adConfig = this.d;
        C2562a9 c2562a9 = this.e;
        C2811p8 c2811p8 = c2562a9.b;
        Intrinsics.checkNotNull(c2811p8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeDataModel");
        C2939x8 c2939x8 = new C2939x8(j, adConfig, c2562a9, c2811p8, this.f);
        this.b = c2939x8;
        this.c = new WeakReference(c2939x8.a(view, parent, false, null));
        C2562a9 c2562a92 = this.e;
        c2562a92.getClass();
        D4.a(new J7(c2562a92, c2562a92), "EndCardBuilderTask");
        return b();
    }

    @Override // com.inmobi.media.Xe
    public final void a() {
        if (this.g) {
            return;
        }
        this.g = true;
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
        super.a();
    }
}
