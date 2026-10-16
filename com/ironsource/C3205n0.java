package com.ironsource;

import com.ironsource.C3051df;
import com.ironsource.D0;
import com.ironsource.InterfaceC3346v6;
import com.ironsource.Ka;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.n0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3205n0 extends C3047db {
    private final IronSource.AD_UNIT b;
    private final C3051df.b c;
    private final B5 d;
    private final G8 e;
    private final long f;

    /* renamed from: com.ironsource.n0$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3594a = new a();

        private a() {
        }

        @JvmStatic
        public static final C3205n0 a(IronSource.AD_UNIT adFormat, D0.b level) {
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(level, "level");
            return new C3205n0(adFormat, level);
        }
    }

    public C3205n0(IronSource.AD_UNIT adFormat, D0.b level) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(level, "level");
        this.e = C3334ub.s.d().e();
        this.f = TimeUnit.HOURS.toMillis(1L);
        this.b = adFormat;
        this.d = new B5(adFormat, level, null, null, 12, null);
        C3051df.b a2 = C3051df.a(adFormat);
        Intrinsics.checkNotNullExpressionValue(a2, "createLogFactory(adFormat)");
        this.c = a2;
    }

    public static /* synthetic */ String a(C3205n0 c3205n0, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogMessage");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return c3205n0.a(str, str2);
    }

    public final String b(String str) {
        return a(this, str, (String) null, 2, (Object) null);
    }

    public final String c() {
        return a(this, (String) null, (String) null, 3, (Object) null);
    }

    protected final IronSource.AD_UNIT d() {
        return this.b;
    }

    public final B5 e() {
        return this.d;
    }

    public final int f() {
        return C3334ub.s.d().s().a(this.b);
    }

    public final boolean g() {
        return C3334ub.s.d().e().c();
    }

    public final String a(String str, String str2) {
        String a2 = this.c.a(str, str2);
        Intrinsics.checkNotNullExpressionValue(a2, "logFactory.createLogMessage(message, suffix)");
        return a2;
    }

    public final com.ironsource.lifecycle.b b() {
        com.ironsource.lifecycle.b d = com.ironsource.lifecycle.b.d();
        Intrinsics.checkNotNullExpressionValue(d, "getInstance()");
        return d;
    }

    public final Placement c(String placementName) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        La a2 = this.e.a();
        if (a2 == null) {
            throw new IllegalStateException("Error getting sdk configurations");
        }
        Placement c = a2.c(LevelPlay.AdFormat.NATIVE_AD, placementName);
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final Ka.a d(String adUnitId) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        La a2 = this.e.a();
        if (a2 != null) {
            return a2.a(adUnitId);
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final Placement a(String placementName) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        La a2 = this.e.a();
        if (a2 != null) {
            Placement c = a2.c(LevelPlay.AdFormat.BANNER, placementName);
            if (c != null) {
                return c;
            }
            throw new IllegalStateException("Error getting placement");
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final InterfaceC3346v6.a b(LevelPlay.AdFormat adFormat, String adUnitId) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        La a2 = this.e.a();
        if (a2 != null) {
            return a2.b(adFormat, adUnitId);
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final long b(LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        La a2 = this.e.a();
        return a2 != null ? a2.b(adFormat) : this.f;
    }

    public final Placement a(LevelPlay.AdFormat adFormat, String str) {
        La a2;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        if (str == null || (a2 = this.e.a()) == null) {
            return null;
        }
        return a2.c(adFormat, str);
    }

    public C3205n0(C3205n0 adTools, D0.b level) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(level, "level");
        this.e = C3334ub.s.d().e();
        this.f = TimeUnit.HOURS.toMillis(1L);
        IronSource.AD_UNIT ad_unit = adTools.b;
        this.b = ad_unit;
        this.c = adTools.c;
        this.d = new B5(ad_unit, level, adTools.d.c(), null, 8, null);
    }

    public final void a(Map<String, Object> data, ISBannerSize size) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(size, "size");
        com.ironsource.mediationsdk.l.a(data, size);
    }

    public final ISBannerSize a(LevelPlayAdSize adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        return new C3154k0().b(adSize);
    }
}
