package com.ironsource;

import android.app.Activity;
import com.ironsource.C3262q6;
import com.ironsource.InterfaceC3346v6;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class J6 implements InterfaceC3346v6, C3262q6.b, C3262q6.a {

    /* renamed from: a, reason: collision with root package name */
    private final C3205n0 f2916a;
    private final InterfaceC3346v6.a b;
    private final InterfaceC3278r6 c;
    private final InterfaceC3312t6 d;
    private final InterfaceC3329u6 e;
    private C3262q6 f;

    public J6(C3205n0 adTools, InterfaceC3346v6.a config, InterfaceC3278r6 fullscreenAdUnitFactory, InterfaceC3312t6 fullscreenAdUnitListener, InterfaceC3329u6 listener) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(fullscreenAdUnitFactory, "fullscreenAdUnitFactory");
        Intrinsics.checkNotNullParameter(fullscreenAdUnitListener, "fullscreenAdUnitListener");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f2916a = adTools;
        this.b = config;
        this.c = fullscreenAdUnitFactory;
        this.d = fullscreenAdUnitListener;
        this.e = listener;
    }

    public final C3205n0 a() {
        return this.f2916a;
    }

    public final InterfaceC3346v6.a b() {
        return this.b;
    }

    @Override // com.ironsource.C3262q6.b
    public void c(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.onAdInfoChanged(adInfo);
    }

    @Override // com.ironsource.InterfaceC3346v6
    public void loadAd() {
        C3262q6 a2 = this.c.a(true, this.d);
        a2.a(this);
        this.f = a2;
    }

    @Override // com.ironsource.InterfaceC3346v6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        C3262q6 c3262q6 = this.f;
        if (c3262q6 != null) {
            c3262q6.a(activity, this);
        }
    }

    @Override // com.ironsource.C3262q6.b
    public void b(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e.b(adInfo);
    }

    @Override // com.ironsource.C3262q6.b
    public void a(C3262q6 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f = null;
        this.e.a();
    }

    @Override // com.ironsource.C3262q6.b
    public void b(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.e.a(ironSourceError);
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
}
