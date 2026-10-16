package com.ironsource;

import com.ironsource.AbstractC3140j3;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ka {

    /* renamed from: a, reason: collision with root package name */
    public static final Ka f2926a = new Ka();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f2927a;
        private final long b;
        private final long c;

        public a(boolean z, long j, long j2) {
            this.f2927a = z;
            this.b = j;
            this.c = j2;
        }

        public final boolean a() {
            return this.f2927a;
        }

        public final long b() {
            return this.b;
        }

        public final long c() {
            return this.c;
        }

        public final long d() {
            return this.b;
        }

        public final long e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2927a == aVar.f2927a && this.b == aVar.b && this.c == aVar.c;
        }

        public final boolean f() {
            return this.f2927a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z = this.f2927a;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return (((r0 * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "BannerStrategyConfig(isAutoRefreshEnabled=" + this.f2927a + ", refreshInterval=" + this.b + ", visibilityCheckerInterval=" + this.c + ")";
        }

        public final a a(boolean z, long j, long j2) {
            return new a(z, j, j2);
        }

        public static /* synthetic */ a a(a aVar, boolean z, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = aVar.f2927a;
            }
            if ((i & 2) != 0) {
                j = aVar.b;
            }
            if ((i & 4) != 0) {
                j2 = aVar.c;
            }
            return aVar.a(z, j, j2);
        }
    }

    private Ka() {
    }

    public final InterfaceC3215na a(C3205n0 adTools, X2 bannerContainer, a config, K2 bannerAdProperties, InterfaceC3232oa strategyListener, O2 bannerAdUnitFactory, InterfaceC3293s4 timeProvider) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(bannerAdProperties, "bannerAdProperties");
        Intrinsics.checkNotNullParameter(strategyListener, "strategyListener");
        Intrinsics.checkNotNullParameter(bannerAdUnitFactory, "bannerAdUnitFactory");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        boolean c = C3334ub.s.d().g().c();
        IronLog.INTERNAL.verbose("Creating banner strategy - useLegacyStrategy: " + c + ", isAutoRefreshEnabled: " + config.f() + ", refreshInterval: " + config.d());
        if (c) {
            return a(adTools, bannerContainer, config, bannerAdProperties, strategyListener, bannerAdUnitFactory, config.f() && config.d() > 0);
        }
        if (config.f()) {
            return new C3282ra(adTools, bannerContainer, config.d(), config.e(), bannerAdProperties, strategyListener, bannerAdUnitFactory, null, timeProvider, 128, null);
        }
        Da da = new Da(adTools, bannerContainer, bannerAdUnitFactory);
        da.a(strategyListener);
        return da;
    }

    private final InterfaceC3215na a(C3205n0 c3205n0, X2 x2, a aVar, K2 k2, InterfaceC3232oa interfaceC3232oa, O2 o2, boolean z) {
        return new C3266qa(new Df(c3205n0, x2, new AbstractC3140j3.b(aVar.d(), z), k2, new Ja(interfaceC3232oa), o2), interfaceC3232oa);
    }
}
