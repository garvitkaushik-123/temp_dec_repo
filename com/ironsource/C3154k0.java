package com.ironsource;

import android.content.Context;
import com.ironsource.C3051df;
import com.ironsource.D0;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.ISContainerParams;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* renamed from: com.ironsource.k0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3154k0 extends C3047db {
    private final B5 b;
    private final C3051df.b c;
    private final G8 d;

    public C3154k0() {
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        this.b = new B5(ad_unit, D0.b.MEDIATION, null, null, 12, null);
        C3051df.b a2 = C3051df.a(ad_unit);
        Intrinsics.checkNotNullExpressionValue(a2, "createLogFactory(IronSource.AD_UNIT.BANNER)");
        this.c = a2;
        this.d = C3334ub.s.d().e();
    }

    public static /* synthetic */ String a(C3154k0 c3154k0, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return c3154k0.a(str, str2);
    }

    private final ISBannerSize c(LevelPlayAdSize levelPlayAdSize) {
        return Intrinsics.areEqual(levelPlayAdSize, LevelPlayAdSize.LARGE) ? new ISBannerSize("LARGE", levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()) : Intrinsics.areEqual(levelPlayAdSize, LevelPlayAdSize.MEDIUM_RECTANGLE) ? new ISBannerSize("RECTANGLE", levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()) : Intrinsics.areEqual(levelPlayAdSize, LevelPlayAdSize.LEADERBOARD) ? new ISBannerSize("SMART", 0, 0) : Intrinsics.areEqual(levelPlayAdSize, LevelPlayAdSize.Companion.createCustomSize(levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight())) ? new ISBannerSize(levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()) : new ISBannerSize("BANNER", levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight());
    }

    public final List<LevelPlayAdSize> b() {
        La a2 = this.d.a();
        if (a2 != null) {
            return a2.h();
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final boolean d() {
        return C3334ub.s.d().e().c();
    }

    public final String a(String str, String str2) {
        String a2 = this.c.a(str, str2);
        Intrinsics.checkNotNullExpressionValue(a2, "logFactory.createLogMessage(message, suffix)");
        return a2;
    }

    public final int a(int i) {
        return com.ironsource.mediationsdk.l.a(i);
    }

    private final ISBannerSize a(LevelPlayAdSize levelPlayAdSize) {
        LevelPlayAdSize fallbackAdSize$mediationsdk_release = levelPlayAdSize.getFallbackAdSize$mediationsdk_release();
        if (fallbackAdSize$mediationsdk_release == null) {
            fallbackAdSize$mediationsdk_release = LevelPlayAdSize.BANNER;
        }
        ISBannerSize b = b(fallbackAdSize$mediationsdk_release);
        b.setAdaptive(true);
        b.containerParams = new ISContainerParams(levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight());
        return b;
    }

    public final Integer b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Float c = c();
        if (c != null) {
            return Integer.valueOf(MathKt.roundToInt(c.floatValue() * C3004b5.f3194a.a(context)));
        }
        return null;
    }

    public final ISBannerSize b(LevelPlayAdSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        boolean isAdaptive = size.isAdaptive();
        if (isAdaptive) {
            return a(size);
        }
        if (isAdaptive) {
            throw new NoWhenBranchMatchedException();
        }
        return c(size);
    }

    private final Float c() {
        La a2 = this.d.a();
        Float valueOf = a2 != null ? Float.valueOf(a2.i()) : null;
        if (valueOf != null) {
            return valueOf;
        }
        this.b.h().f("MaxScreenSizePercentageForBannerHeight is null: Error getting sdk configurations");
        return null;
    }
}
