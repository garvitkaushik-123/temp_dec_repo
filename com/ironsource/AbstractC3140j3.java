package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.j3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3140j3 {
    public static final a c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final b f3370a;
    private final K2 b;

    /* renamed from: com.ironsource.j3$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AbstractC3140j3 a(C3205n0 adTools, X2 bannerContainer, b config, K2 bannerAdProperties, InterfaceC3174l3 bannerStrategyListener, O2 createBannerAdUnitFactory) {
            Intrinsics.checkNotNullParameter(adTools, "adTools");
            Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(bannerAdProperties, "bannerAdProperties");
            Intrinsics.checkNotNullParameter(bannerStrategyListener, "bannerStrategyListener");
            Intrinsics.checkNotNullParameter(createBannerAdUnitFactory, "createBannerAdUnitFactory");
            return new Df(adTools, bannerContainer, config, bannerAdProperties, bannerStrategyListener, createBannerAdUnitFactory);
        }

        private a() {
        }
    }

    /* renamed from: com.ironsource.j3$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f3371a;
        private final boolean b;

        public b(long j, boolean z) {
            this.f3371a = j;
            this.b = z;
        }

        public final long a() {
            return this.f3371a;
        }

        public final boolean b() {
            return this.b;
        }

        public final long c() {
            return this.f3371a;
        }

        public final boolean d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3371a == bVar.f3371a && this.b == bVar.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = Long.hashCode(this.f3371a) * 31;
            boolean z = this.b;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            return "Config(refreshInterval=" + this.f3371a + ", isAutoRefreshEnabled=" + this.b + ")";
        }

        public final b a(long j, boolean z) {
            return new b(j, z);
        }

        public static /* synthetic */ b a(b bVar, long j, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = bVar.f3371a;
            }
            if ((i & 2) != 0) {
                z = bVar.b;
            }
            return bVar.a(j, z);
        }
    }

    public AbstractC3140j3(b config, K2 bannerAdProperties) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(bannerAdProperties, "bannerAdProperties");
        this.f3370a = config;
        this.b = bannerAdProperties;
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    protected final long g() {
        Long j = this.b.j();
        return j != null ? j.longValue() : this.f3370a.c();
    }

    protected final boolean h() {
        Boolean i = this.b.i();
        return i != null ? i.booleanValue() : this.f3370a.d();
    }
}
