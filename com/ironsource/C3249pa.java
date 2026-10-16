package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ironsource.D0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.sdk.mediation.R;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.LevelPlayAdSize;
import com.unity3d.mediation.banner.LevelPlayBannerAdView;
import com.unity3d.mediation.banner.LevelPlayBannerAdViewListener;
import java.util.UUID;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.pa, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3249pa implements InterfaceC3376x2 {
    public static final a n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final UUID f3638a;
    private final String b;
    private final X2 c;
    private final LevelPlayBannerAdView.Config d;
    private final C3205n0 e;
    private final P8 f;
    private LevelPlayAdSize g;
    private LevelPlayBannerAdViewListener h;
    private String i;
    private InterfaceC3161k7 j;
    private Boolean k;
    private Placement l;
    private boolean m;

    /* renamed from: com.ironsource.pa$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair<String, LevelPlayBannerAdView.Config> a(Context context, AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            String str = "";
            if (attributeSet == null) {
                return TuplesKt.to("", LevelPlayBannerAdView.Config.Companion.empty());
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LevelPlayBannerAdView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…le.LevelPlayBannerAdView)");
            try {
                LevelPlayBannerAdView.Config.Builder builder = new LevelPlayBannerAdView.Config.Builder();
                if (obtainStyledAttributes.hasValue(R.styleable.LevelPlayBannerAdView_bidFloor)) {
                    builder.setBidFloor(obtainStyledAttributes.getFloat(R.styleable.LevelPlayBannerAdView_bidFloor, -1.0f));
                }
                String string = obtainStyledAttributes.getString(R.styleable.LevelPlayBannerAdView_adSize);
                if (string != null) {
                    builder.setAdSize(LevelPlayAdSize.Companion.createAdSize$mediationsdk_release(string));
                }
                String string2 = obtainStyledAttributes.getString(R.styleable.LevelPlayBannerAdView_adUnitId);
                if (string2 != null) {
                    str = string2;
                }
                return TuplesKt.to(str, builder.build());
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        private a() {
        }
    }

    public C3249pa(UUID adId, String adUnitId, X2 bannerContainer, LevelPlayBannerAdView.Config config, C3205n0 adTools) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        this.f3638a = adId;
        this.b = adUnitId;
        this.c = bannerContainer;
        this.d = config;
        this.e = adTools;
        this.f = C3334ub.s.d().A();
        LevelPlayAdSize adSize = config.getAdSize();
        this.g = adSize == null ? LevelPlayAdSize.BANNER : adSize;
        String placementName = config.getPlacementName();
        this.i = placementName == null ? "" : placementName;
        adTools.e().a(new C3204n(IronSource.AD_UNIT.BANNER, adId, adUnitId));
        Double bidFloor = config.getBidFloor();
        if (bidFloor != null) {
            adTools.e().f().a(bidFloor.doubleValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final C3249pa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.m) {
            IronLog.INTERNAL.warning(C3205n0.a(this$0.e, "Banner not loaded", (String) null, 2, (Object) null));
            return;
        }
        if (this$0.j == null) {
            IronLog.INTERNAL.warning(C3205n0.a(this$0.e, "Banner already destroyed", (String) null, 2, (Object) null));
            return;
        }
        C3047db.a(this$0.e, new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.b(C3249pa.this);
            }
        }, 0L, 2, (Object) null);
        InterfaceC3161k7 interfaceC3161k7 = this$0.j;
        if (interfaceC3161k7 != null) {
            interfaceC3161k7.c();
        }
        this$0.j = null;
        this$0.k = null;
        this$0.h = null;
    }

    private final boolean h() {
        if (this.b.length() == 0) {
            String uuid = this.f3638a.toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "adId.toString()");
            a(new LevelPlayAdError(uuid, this.b, LevelPlayAdError.ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED, "Ad unit ID should be specified"));
            return false;
        }
        if (!this.e.g()) {
            String uuid2 = this.f3638a.toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "adId.toString()");
            a(new LevelPlayAdError(uuid2, this.b, LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, "load must be called after init success callback"));
            return false;
        }
        La a2 = C3334ub.s.d().e().a();
        if (a2 != null && a2.a(this.b, LevelPlay.AdFormat.BANNER)) {
            return true;
        }
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this.h;
        if (levelPlayBannerAdViewListener != null) {
            String uuid3 = this.f3638a.toString();
            Intrinsics.checkNotNullExpressionValue(uuid3, "adId.toString()");
            levelPlayBannerAdViewListener.onAdLoadFailed(new LevelPlayAdError(uuid3, this.b, LevelPlayAdError.ERROR_CODE_INVALID_AD_UNIT_ID, "Invalid ad unit id"));
        }
        return false;
    }

    public final void b() {
        IronLog.API.info("LevelPlayBannerAdView.destroyBanner()");
        this.e.d(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.a(C3249pa.this);
            }
        });
    }

    public final UUID c() {
        return this.f3638a;
    }

    public final LevelPlayAdSize d() {
        return this.g;
    }

    public final String e() {
        return this.b;
    }

    public final LevelPlayBannerAdViewListener f() {
        return this.h;
    }

    public final String g() {
        return this.i;
    }

    public final void i() {
        IronLog.API.info("LevelPlayBannerAdView.loadAd()");
        this.e.d(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.c(C3249pa.this);
            }
        });
    }

    public final void j() {
        Unit unit;
        IronLog.API.info("LevelPlayBannerAdView.pauseAutoRefresh()");
        final InterfaceC3161k7 interfaceC3161k7 = this.j;
        if (interfaceC3161k7 != null) {
            this.e.d(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    C3249pa.a(C3249pa.this, interfaceC3161k7);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.k = Boolean.FALSE;
        }
    }

    public final void k() {
        Unit unit;
        IronLog.API.info("LevelPlayBannerAdView.resumeAutoRefresh()");
        final InterfaceC3161k7 interfaceC3161k7 = this.j;
        if (interfaceC3161k7 != null) {
            this.e.d(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    C3249pa.b(C3249pa.this, interfaceC3161k7);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.k = Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C3249pa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.m) {
            IronLog.INTERNAL.warning(C3205n0.a(this$0.e, "Banner load already called", (String) null, 2, (Object) null));
            return;
        }
        this$0.m = true;
        if (this$0.h()) {
            InterfaceC3161k7 a2 = this$0.a();
            this$0.j = a2;
            Boolean bool = this$0.k;
            if (bool != null) {
                if (bool.booleanValue()) {
                    a2.e();
                } else {
                    a2.d();
                }
            }
            a2.b();
        }
    }

    @Override // com.ironsource.InterfaceC3376x2
    public void d(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.e(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.a(LevelPlayAdInfo.this, this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3376x2
    public void e(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.e(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.c(LevelPlayAdInfo.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3249pa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c.removeAllViews();
        ViewParent parent = this$0.c.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this$0.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LevelPlayAdInfo adInfo, C3249pa this$0) {
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdScreenDismissed() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdCollapsed(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LevelPlayAdInfo adInfo, C3249pa this$0) {
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdScreenPresented() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdExpanded(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3249pa this$0, InterfaceC3161k7 it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.e.e().f().c();
        it.e();
    }

    @Override // com.ironsource.InterfaceC3376x2
    public void b(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.e(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.b(LevelPlayAdInfo.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LevelPlayAdInfo adInfo, C3249pa this$0) {
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdDisplayed() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdDisplayed(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LevelPlayAdInfo adInfo, C3249pa this$0) {
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdLeftApplication() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLeftApplication(adInfo);
        }
    }

    public final void a(final LevelPlayBannerAdViewListener levelPlayBannerAdViewListener) {
        IronLog.API.info("LevelPlayBannerAdView.setBannerListener()");
        this.e.d(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.a(C3249pa.this, levelPlayBannerAdViewListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3249pa this$0, LevelPlayBannerAdViewListener levelPlayBannerAdViewListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h = levelPlayBannerAdViewListener;
    }

    public final void a(final LevelPlayAdSize adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        IronLog.API.info("LevelPlayBannerAdView.setBannerAdSize() adSize: " + adSize);
        this.e.d(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.a(C3249pa.this, adSize);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3376x2
    public void c(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.e(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.d(LevelPlayAdInfo.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3249pa this$0, LevelPlayAdSize adSize) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adSize, "$adSize");
        if (this$0.m) {
            return;
        }
        this$0.g = adSize;
    }

    public final void a(final String placementName) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        IronLog.API.info("LevelPlayBannerAdView.setPlacementName() placementName: " + placementName);
        this.e.d(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.a(C3249pa.this, placementName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3249pa this$0, String placementName) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(placementName, "$placementName");
        if (this$0.m) {
            return;
        }
        this$0.i = placementName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3249pa this$0, InterfaceC3161k7 it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.e.e().f().b();
        it.d();
    }

    private final InterfaceC3161k7 a() {
        Placement placement;
        this.l = this.e.a(this.i);
        Context context = this.c.getContext();
        if (context instanceof Activity) {
            ContextProvider.getInstance().updateActivity((Activity) context);
        }
        UUID uuid = this.f3638a;
        String str = this.b;
        Placement placement2 = this.l;
        if (placement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerPlacement");
            placement = null;
        } else {
            placement = placement2;
        }
        K2 k2 = new K2(uuid, str, placement, this.g, null, null, this.f.a(), this.d.getBidFloor(), 48, null);
        this.e.e().a(new B0(this.e, k2, null, 4, null));
        ISBannerSize a2 = this.e.a(k2.h());
        B5 e = this.e.e();
        C3205n0 c3205n0 = this.e;
        Placement placement3 = this.l;
        if (placement3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerPlacement");
            placement3 = null;
        }
        e.a(new Z2(c3205n0, a2, placement3.getPlacementName()));
        if (C3334ub.s.d().g().c()) {
            IronLog.INTERNAL.verbose(C3205n0.a(this.e, "Using legacy BannerAdController", (String) null, 2, (Object) null));
            return new C3359w2(this, this.e, k2, this.c);
        }
        IronLog.INTERNAL.verbose(C3205n0.a(this.e, "Using new LevelPlayBannerAdController", (String) null, 2, (Object) null));
        return new C3198ma(this, this.e, k2, this.c);
    }

    public /* synthetic */ C3249pa(UUID uuid, String str, X2 x2, LevelPlayBannerAdView.Config config, C3205n0 c3205n0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C3347v7.f3910a.a() : uuid, str, x2, config, (i & 16) != 0 ? new C3205n0(IronSource.AD_UNIT.BANNER, D0.b.MEDIATION) : c3205n0);
    }

    @Override // com.ironsource.InterfaceC3376x2
    public void a(final LevelPlayAdInfo adInfo, final boolean z) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.e(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.a(z, adInfo, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(boolean z, LevelPlayAdInfo adInfo, C3249pa this$0) {
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdLoaded() isReload: " + z + " adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLoaded(adInfo);
        }
    }

    @Override // com.ironsource.InterfaceC3376x2
    public void a(final LevelPlayAdError levelPlayAdError) {
        if (levelPlayAdError != null) {
            this.e.e(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    C3249pa.a(LevelPlayAdError.this, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdError it, C3249pa this$0) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdLoadFailed() error: " + it);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLoadFailed(it);
        }
    }

    @Override // com.ironsource.InterfaceC3376x2
    public void a(final LevelPlayAdInfo adInfo, final LevelPlayAdError levelPlayAdError) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (levelPlayAdError != null) {
            this.e.e(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    C3249pa.a(LevelPlayAdInfo.this, levelPlayAdError, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdInfo adInfo, LevelPlayAdError it, C3249pa this$0) {
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdDisplayFailed() adInfo " + adInfo + " error: " + it);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdDisplayFailed(adInfo, it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdInfo adInfo, C3249pa this$0) {
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdClicked() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdClicked(adInfo);
        }
    }

    @Override // com.ironsource.InterfaceC3376x2
    public void a(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.e(new Runnable() { // from class: com.ironsource.pa$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3249pa.e(LevelPlayAdInfo.this, this);
            }
        });
    }
}
