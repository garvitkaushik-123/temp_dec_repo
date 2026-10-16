package com.ironsource;

import android.app.Activity;
import com.ironsource.C3110h6;
import com.ironsource.C3205n0;
import com.ironsource.D0;
import com.ironsource.InterfaceC3121i0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class Na implements InterfaceC3093g6 {
    public static final a n = new a(null);
    public static final String o = "Fullscreen Ad Internal";

    /* renamed from: a, reason: collision with root package name */
    private final LevelPlay.AdFormat f2965a;
    private final String b;
    private final b c;
    private final C3205n0 d;
    private final C3076f6 e;
    private final InterfaceC3357w0 f;
    private final H7 g;
    private final InterfaceC3293s4 h;
    private final Lazy i;
    private Oa j;
    private final UUID k;
    private InterfaceC3245p6 l;
    private C3126i5 m;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(String placementName, LevelPlay.AdFormat adFormat) {
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            C3205n0 a2 = C3205n0.a.a(com.unity3d.mediation.a.a(adFormat), D0.b.MEDIATION);
            if (!a2.g()) {
                a2.e().a().a(placementName, "SDK is not initialized", false);
                return false;
            }
            N3 a3 = C3334ub.s.d().p().a(placementName, adFormat);
            boolean d = a3.d();
            a2.e().a().a(placementName, a3.e(), d);
            return d;
        }

        private a() {
        }
    }

    public interface b {
        Double getBidFloor();
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final C3205n0 f2966a;
        private final C3076f6 b;
        private final H7 c;
        private final InterfaceC3293s4 d;
        private final C3347v7 e;
        private final b f;

        public c(C3205n0 adTools, C3076f6 adControllerFactory, H7 provider, InterfaceC3293s4 currentTimeProvider, C3347v7 idFactory, b config) {
            Intrinsics.checkNotNullParameter(adTools, "adTools");
            Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
            Intrinsics.checkNotNullParameter(provider, "provider");
            Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
            Intrinsics.checkNotNullParameter(idFactory, "idFactory");
            Intrinsics.checkNotNullParameter(config, "config");
            this.f2966a = adTools;
            this.b = adControllerFactory;
            this.c = provider;
            this.d = currentTimeProvider;
            this.e = idFactory;
            this.f = config;
        }

        public final C3076f6 a() {
            return this.b;
        }

        public final C3205n0 b() {
            return this.f2966a;
        }

        public final b c() {
            return this.f;
        }

        public final InterfaceC3293s4 d() {
            return this.d;
        }

        public final C3347v7 e() {
            return this.e;
        }

        public final H7 f() {
            return this.c;
        }
    }

    static final class d extends Lambda implements Function0<C3059e6> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C3059e6 invoke() {
            return Na.this.b();
        }
    }

    public static final class e implements InterfaceC3278r6 {
        final /* synthetic */ C3070f0 b;

        e(C3070f0 c3070f0) {
            this.b = c3070f0;
        }

        @Override // com.ironsource.InterfaceC3278r6
        public C3262q6 a(boolean z, InterfaceC3312t6 listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            AbstractC3340v0 a2 = Na.this.g().a(z, this.b);
            return new C3262q6(C3334ub.s.c(), new V0(Na.this.f(), a2, D0.b.MEDIATION), a2, listener, null, null, null, null, 240, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Na(LevelPlay.AdFormat adFormat, String adUnitId, b config, C3205n0 adTools, C3076f6 fullscreenAdControllerFactory, InterfaceC3357w0 adUnitDataFactory, H7 mediationServicesProvider, InterfaceC3293s4 currentTimeProvider, C3347v7 idFactory) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(fullscreenAdControllerFactory, "fullscreenAdControllerFactory");
        Intrinsics.checkNotNullParameter(adUnitDataFactory, "adUnitDataFactory");
        Intrinsics.checkNotNullParameter(mediationServicesProvider, "mediationServicesProvider");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(idFactory, "idFactory");
        this.f2965a = adFormat;
        this.b = adUnitId;
        this.c = config;
        this.d = adTools;
        this.e = fullscreenAdControllerFactory;
        this.f = adUnitDataFactory;
        this.g = mediationServicesProvider;
        this.h = currentTimeProvider;
        this.i = LazyKt.lazy(new d());
        UUID a2 = idFactory.a();
        this.k = a2;
        this.l = new C3110h6(this, null, 2, 0 == true ? 1 : 0);
        adTools.e().a(new C3204n(com.unity3d.mediation.a.a(adFormat), a2, adUnitId));
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Na this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d.e().f().a();
        this$0.l.loadAd();
    }

    private final void p() {
        Double bidFloor = this.c.getBidFloor();
        if (bidFloor != null) {
            this.d.e().f().a(bidFloor.doubleValue());
        }
    }

    public final C3059e6 c() {
        return (C3059e6) this.i.getValue();
    }

    public final LevelPlay.AdFormat d() {
        return this.f2965a;
    }

    public final UUID e() {
        return this.k;
    }

    public final C3205n0 f() {
        return this.d;
    }

    public final InterfaceC3357w0 g() {
        return this.f;
    }

    public final String h() {
        return this.b;
    }

    public final b i() {
        return this.c;
    }

    public final InterfaceC3293s4 j() {
        return this.h;
    }

    public final Oa k() {
        return this.j;
    }

    public final H7 l() {
        return this.g;
    }

    public final boolean m() {
        InterfaceC3121i0 c2 = this.l.c();
        this.d.e().e().a(Boolean.valueOf(c2.a()), c2 instanceof InterfaceC3121i0.a ? ((InterfaceC3121i0.a) c2).c() : null);
        return c2.a();
    }

    public final void n() {
        this.m = new C3126i5();
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                Na.b(Na.this);
            }
        });
    }

    public final void o() {
        a(new C3194m6(this, this.h));
        c().p();
    }

    @Override // com.ironsource.InterfaceC3093g6
    public void onAdClicked() {
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                Na.c(Na.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3093g6
    public void onAdClosed() {
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                Na.d(Na.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3093g6
    public void onAdDisplayed(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                Na.b(Na.this, adInfo);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3093g6
    public void onAdInfoChanged(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                Na.c(Na.this, adInfo);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3093g6
    public void onAdLoadFailed(final LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                Na.c(Na.this, error);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3093g6
    public void onAdLoaded(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                Na.d(Na.this, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Na this$0, LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        this$0.l.onAdLoadFailed(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Na this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        this$0.l.onAdLoaded(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Na this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l.a();
    }

    public final void a(Oa oa) {
        this.j = oa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Na this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        this$0.l.onAdDisplayed(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Na this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l.onAdClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Na this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l.onAdClosed();
    }

    public final void a(InterfaceC3245p6 state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.l = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Na this$0, LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        this$0.l.a(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Na this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        this$0.l.onAdInfoChanged(adInfo);
    }

    public final void a(final Activity activity, final String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Na.a(activity, this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Activity activity, Na this$0, String str) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ContextProvider.getInstance().updateActivity(activity);
        this$0.d.e().h().d();
        this$0.l.a(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3059e6 b() {
        C3070f0 c3070f0 = new C3070f0(com.unity3d.mediation.a.a(this.f2965a), this.k, this.b, null, this.g.A().a(), this.c.getBidFloor(), 8, null);
        e eVar = new e(c3070f0);
        B5 e2 = this.d.e();
        C3205n0 c3205n0 = this.d;
        e2.a(new B0(c3205n0, c3070f0, c3205n0.b(this.f2965a, this.b).b().b()));
        return this.e.a(this, this.d, c3070f0, eVar);
    }

    public final void a(C3110h6.a status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.l = new C3110h6(this, status);
    }

    @Override // com.ironsource.InterfaceC3093g6
    public void a(final LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Na.b(Na.this, error);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3093g6
    public void a() {
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                Na.e(Na.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3093g6
    public void a(final LevelPlayReward reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        IronLog.INTERNAL.verbose(C3205n0.a(this.d, "onAdRewarded adInfo: " + this.l.b() + " reward: " + reward, (String) null, 2, (Object) null));
        this.d.e(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Na.a(Na.this, reward);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Na this$0, LevelPlayReward reward) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reward, "$reward");
        Oa oa = this$0.j;
        if (oa != null) {
            oa.onAdRewarded(reward, this$0.l.b());
        }
    }

    public final void a(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        IronLog.INTERNAL.verbose(C3205n0.a(this.d, "onAdLoaded adInfo: " + adInfo, (String) null, 2, (Object) null));
        final long a2 = C3126i5.a(this.m);
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Na.a(Na.this, a2);
            }
        });
        this.d.e(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Na.a(Na.this, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Na this$0, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d.e().f().a(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Na this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Oa oa = this$0.j;
        if (oa != null) {
            oa.onAdLoaded(adInfo);
        }
    }

    public static /* synthetic */ void a(Na na, LevelPlayAdError levelPlayAdError, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        na.a(levelPlayAdError, j);
    }

    public final void a(final LevelPlayAdError levelPlayAdError, final long j) {
        IronLog.INTERNAL.verbose(C3205n0.a(this.d, "onAdLoadFailed error: " + levelPlayAdError, (String) null, 2, (Object) null));
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                Na.a(Na.this, j, levelPlayAdError);
            }
        });
        this.d.e(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                Na.a(LevelPlayAdError.this, this);
            }
        });
    }

    public /* synthetic */ Na(LevelPlay.AdFormat adFormat, String str, b bVar, C3205n0 c3205n0, C3076f6 c3076f6, InterfaceC3357w0 interfaceC3357w0, H7 h7, InterfaceC3293s4 interfaceC3293s4, C3347v7 c3347v7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adFormat, str, bVar, c3205n0, c3076f6, interfaceC3357w0, (i & 64) != 0 ? C3334ub.s.d() : h7, interfaceC3293s4, c3347v7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Na this$0, long j, LevelPlayAdError levelPlayAdError) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dc f = this$0.d.e().f();
        int errorCode = levelPlayAdError != null ? levelPlayAdError.getErrorCode() : 0;
        if (levelPlayAdError == null || (str = levelPlayAdError.getErrorMessage()) == null) {
            str = "";
        }
        f.a(j, errorCode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdError levelPlayAdError, Na this$0) {
        Oa oa;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (levelPlayAdError == null || (oa = this$0.j) == null) {
            return;
        }
        oa.onAdLoadFailed(levelPlayAdError);
    }

    public final void a(final LevelPlayAdError error, final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        IronLog.INTERNAL.verbose(C3205n0.a(this.d, "onAdDisplayFailed error: " + error + ", adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.d.d(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                Na.a(Na.this, error);
            }
        });
        this.d.e(new Runnable() { // from class: com.ironsource.Na$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                Na.a(Na.this, error, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Na this$0, LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        this$0.d.e().h().a(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Na this$0, LevelPlayAdError error, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Oa oa = this$0.j;
        if (oa != null) {
            oa.onAdDisplayFailed(error, adInfo);
        }
    }

    public final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.d.e().h().f("Fullscreen Ad Internal - " + message);
    }
}
