package com.inmobi.media;

import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.i6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2695i6 extends AbstractC2679h6 {

    /* renamed from: a, reason: collision with root package name */
    public final InterstitialAdEventListener f2597a;

    public C2695i6(InterstitialAdEventListener adEventListener) {
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        this.f2597a = adEventListener;
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, Map params) {
        InMobiInterstitial ad = (InMobiInterstitial) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f2597a.onAdClicked(ad, params);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void b(Object obj, AdMetaInfo info) {
        InMobiInterstitial ad = (InMobiInterstitial) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(info, "info");
        this.f2597a.onAdLoadSucceeded(ad, info);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, AdMetaInfo info) {
        InMobiInterstitial ad = (InMobiInterstitial) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(info, "info");
        this.f2597a.onAdFetchSuccessful(ad, info);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj) {
        InMobiInterstitial ad = (InMobiInterstitial) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f2597a.onAdImpression(ad);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, InMobiAdRequestStatus status) {
        InMobiInterstitial ad = (InMobiInterstitial) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(status, "status");
        this.f2597a.onAdLoadFailed(ad, status);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, String data) {
        InMobiInterstitial ad = (InMobiInterstitial) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            Class<?> cls = Class.forName("IMraidLog");
            Method declaredMethod = cls.getDeclaredMethod("imraidLog", InterstitialAdEventListener.class, InMobiInterstitial.class, String.class);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
            declaredMethod.invoke(cls.newInstance(), this.f2597a, ad, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
