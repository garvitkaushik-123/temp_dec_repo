package com.inmobi.media;

import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.listeners.NativeAdEventListener;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class V7 extends U7 {

    /* renamed from: a, reason: collision with root package name */
    public final NativeAdEventListener f2461a;

    public V7(NativeAdEventListener adEventListener) {
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        this.f2461a = adEventListener;
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, AdMetaInfo info) {
        InMobiNative ad = (InMobiNative) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(info, "info");
        this.f2461a.onAdFetchSuccessful(ad, info);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void b(Object obj, AdMetaInfo info) {
        InMobiNative ad = (InMobiNative) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(info, "info");
        this.f2461a.onAdLoadSucceeded(ad, info);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj) {
        InMobiNative ad = (InMobiNative) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f2461a.onAdImpression(ad);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, InMobiAdRequestStatus status) {
        InMobiNative ad = (InMobiNative) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(status, "status");
        this.f2461a.onAdLoadFailed(ad, status);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, String data) {
        InMobiNative ad = (InMobiNative) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            Class<?> cls = Class.forName("IMraidLog");
            Method declaredMethod = cls.getDeclaredMethod("imraidLog", NativeAdEventListener.class, InMobiNative.class, String.class);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
            declaredMethod.invoke(cls.newInstance(), this.f2461a, ad, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
