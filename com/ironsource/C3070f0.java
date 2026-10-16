package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlay;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.f0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3070f0 {

    /* renamed from: a, reason: collision with root package name */
    private final IronSource.AD_UNIT f3288a;
    private final UUID b;
    private final String c;
    private Placement d;
    private final C3203mf e;
    private final Double f;

    /* renamed from: com.ironsource.f0$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3289a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3289a = iArr;
        }
    }

    public C3070f0(IronSource.AD_UNIT adFormat, UUID adId, String adUnitId, Placement placement, C3203mf c3203mf, Double d) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f3288a = adFormat;
        this.b = adId;
        this.c = adUnitId;
        this.d = placement;
        this.e = c3203mf;
        this.f = d;
    }

    public final IronSource.AD_UNIT a() {
        return this.f3288a;
    }

    public final UUID b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final Double d() {
        return this.f;
    }

    public final LevelPlay.AdFormat e() {
        int i = a.f3289a[this.f3288a.ordinal()];
        if (i == 1) {
            return LevelPlay.AdFormat.REWARDED;
        }
        if (i == 2) {
            return LevelPlay.AdFormat.INTERSTITIAL;
        }
        if (i == 3) {
            return LevelPlay.AdFormat.BANNER;
        }
        if (i == 4) {
            return LevelPlay.AdFormat.NATIVE_AD;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Placement f() {
        return this.d;
    }

    public final C3203mf g() {
        return this.e;
    }

    public final void a(Placement placement) {
        this.d = placement;
    }

    public /* synthetic */ C3070f0(IronSource.AD_UNIT ad_unit, UUID uuid, String str, Placement placement, C3203mf c3203mf, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ad_unit, uuid, str, (i & 8) != 0 ? null : placement, (i & 16) != 0 ? null : c3203mf, (i & 32) != 0 ? null : d);
    }
}
