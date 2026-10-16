package com.inmobi.media;

import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.listeners.BannerAdEventListener;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class I1 extends H1 {

    /* renamed from: a, reason: collision with root package name */
    public final BannerAdEventListener f2310a;

    public I1(BannerAdEventListener adEventListener) {
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        this.f2310a = adEventListener;
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, Map params) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f2310a.onAdClicked(ad, params);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void b(Object obj, AdMetaInfo info) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(info, "info");
        this.f2310a.onAdLoadSucceeded(ad, info);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, AdMetaInfo info) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(info, "info");
        this.f2310a.onAdFetchSuccessful(ad, info);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f2310a.onAdImpression(ad);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, InMobiAdRequestStatus status) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullExpressionValue("H1", "getSimpleName(...)");
        this.f2310a.onAdLoadFailed(ad, status);
    }

    @Override // com.inmobi.media.AbstractC2965z
    public final void a(Object obj, String data) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            Class<?> cls = Class.forName("IMraidLog");
            Method declaredMethod = cls.getDeclaredMethod("imraidLog", BannerAdEventListener.class, InMobiBanner.class, String.class);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
            declaredMethod.invoke(cls.newInstance(), this.f2310a, ad, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
