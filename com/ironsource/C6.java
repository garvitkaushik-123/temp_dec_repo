package com.ironsource;

import android.app.Activity;
import com.ironsource.C3262q6;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class C6 implements InterfaceC3346v6, C3262q6.b, C3262q6.a {
    public static final a f = new a(null);
    public static final String g = "Fullscreen ProgressiveOnShown Strategy";

    /* renamed from: a, reason: collision with root package name */
    private final C3205n0 f2812a;
    private final InterfaceC3278r6 b;
    private final InterfaceC3312t6 c;
    private final InterfaceC3329u6 d;
    private I6 e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public C6(C3205n0 adTools, InterfaceC3278r6 factory, InterfaceC3312t6 fullscreenAdUnitListener, InterfaceC3329u6 listener) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(fullscreenAdUnitListener, "fullscreenAdUnitListener");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f2812a = adTools;
        this.b = factory;
        this.c = fullscreenAdUnitListener;
        this.d = listener;
        this.e = new D6(this, null, false, 4, null);
    }

    public final C3205n0 a() {
        return this.f2812a;
    }

    public final InterfaceC3278r6 b() {
        return this.b;
    }

    public final InterfaceC3312t6 c() {
        return this.c;
    }

    public final InterfaceC3329u6 d() {
        return this.d;
    }

    @Override // com.ironsource.InterfaceC3346v6
    public void loadAd() {
        this.e.loadAd();
    }

    @Override // com.ironsource.InterfaceC3346v6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.e.a(activity);
    }

    @Override // com.ironsource.C3262q6.b
    public void b(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.c(adInfo);
    }

    @Override // com.ironsource.C3262q6.b
    public void c(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.b(adInfo);
    }

    public final void a(I6 state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.e = state;
    }

    @Override // com.ironsource.C3262q6.b
    public void b(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.e.a(ironSourceError);
    }

    public final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f2812a.e().h().f("Fullscreen ProgressiveOnShown Strategy - " + message);
    }

    @Override // com.ironsource.C3262q6.a
    public void a(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.a(adInfo);
    }

    @Override // com.ironsource.C3262q6.a
    public void a(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.e.b(ironSourceError);
    }

    @Override // com.ironsource.C3262q6.b
    public void a(C3262q6 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.e.a();
    }
}
