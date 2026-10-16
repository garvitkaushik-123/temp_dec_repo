package com.ironsource;

import com.ironsource.D0;
import com.ironsource.Va;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Wa extends AbstractC3164ka implements Eb {
    private final UUID d;
    private final Ua e;
    private Bb f;
    private String g;
    private Placement h;
    private Ya i;
    private AdapterNativeAdData j;
    private AdapterNativeAdViewBinder k;

    public /* synthetic */ Wa(UUID uuid, Ua ua, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C3347v7.f3910a.a() : uuid, ua);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Wa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.API.info(String.valueOf(this$0));
        try {
            Bb bb = this$0.f;
            if (bb == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nativeAdController");
                bb = null;
            }
            bb.q();
            this$0.i = null;
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.API.error("destroyNativeAd()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Wa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bb bb = null;
        if (this$0.c()) {
            IronLog.INTERNAL.warning(C3205n0.a(this$0.a(), "Native ad load already called", (String) null, 2, (Object) null));
            return;
        }
        this$0.a(true);
        if (this$0.d()) {
            Bb bb2 = this$0.f;
            if (bb2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nativeAdController");
            } else {
                bb = bb2;
            }
            bb.r();
        }
    }

    private final Bb e() {
        this.h = a().c(this.g);
        UUID uuid = this.d;
        String b = b();
        Placement placement = this.h;
        if (placement == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placement");
            placement = null;
        }
        Lb lb = new Lb(uuid, b, placement);
        a(lb);
        return new Bb(this, a(), lb);
    }

    @Override // com.ironsource.AbstractC3164ka
    public boolean d() {
        this.f = e();
        return true;
    }

    public final void f() {
        a(new Runnable() { // from class: com.ironsource.Wa$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Wa.a(Wa.this);
            }
        });
    }

    public final UUID g() {
        return this.d;
    }

    public final String h() {
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getAdvertiser();
        }
        return null;
    }

    public final String i() {
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getBody();
        }
        return null;
    }

    public final String j() {
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getCallToAction();
        }
        return null;
    }

    public final Va.a k() {
        NativeAdDataInterface.Image icon;
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData == null || (icon = adapterNativeAdData.getIcon()) == null) {
            return null;
        }
        return new Va.a(icon.getDrawable(), icon.getUri());
    }

    public final AdapterNativeAdViewBinder l() {
        return this.k;
    }

    public final String m() {
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getTitle();
        }
        return null;
    }

    public final void n() {
        a(new Runnable() { // from class: com.ironsource.Wa$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Wa.b(Wa.this);
            }
        });
    }

    @Override // com.ironsource.Eb
    public void onNativeAdLoadFailed(IronSourceError ironSourceError) {
        String uuid = this.d.toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adId.toString()");
        final LevelPlayAdError levelPlayAdError = new LevelPlayAdError(ironSourceError, uuid, b());
        b(new Runnable() { // from class: com.ironsource.Wa$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                Wa.a(Wa.this, levelPlayAdError);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Wa(UUID adId, Ua nativeAd) {
        super(new C3205n0(r1, D0.b.MEDIATION));
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.NATIVE_AD;
        this.d = adId;
        this.e = nativeAd;
        this.g = "";
        a().e().a(new C3204n(ad_unit, adId, b()));
    }

    public final void a(final Ya ya) {
        a(new Runnable() { // from class: com.ironsource.Wa$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Wa.a(Wa.this, ya);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Wa this$0, Ya ya) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i = ya;
    }

    @Override // com.ironsource.Eb
    public void a(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        IronLog.CALLBACK.info(String.valueOf(this));
        C3402yb c3402yb = new C3402yb();
        Bb bb = this.f;
        if (bb == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeAdController");
            bb = null;
        }
        bb.a(c3402yb);
        this.j = c3402yb.a();
        this.k = c3402yb.b();
        b(new Runnable() { // from class: com.ironsource.Wa$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Wa.b(Wa.this, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Wa this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Ya ya = this$0.i;
        if (ya != null) {
            ya.b(this$0.e, adInfo);
        }
    }

    @Override // com.ironsource.Eb
    public void b(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.Wa$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                Wa.a(Wa.this, adInfo);
            }
        });
    }

    public final void b(final String placementName) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        a(new Runnable() { // from class: com.ironsource.Wa$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Wa.a(Wa.this, placementName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Wa this$0, LevelPlayAdError levelPlayError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(levelPlayError, "$levelPlayError");
        Ya ya = this$0.i;
        if (ya != null) {
            ya.a(this$0.e, levelPlayError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Wa this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Ya ya = this$0.i;
        if (ya != null) {
            ya.c(this$0.e, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Wa this$0, String placementName) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(placementName, "$placementName");
        this$0.g = placementName;
    }
}
