package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class U3 {

    /* renamed from: a, reason: collision with root package name */
    private final Gd f3070a;
    private final C3366w9 b;
    private final V2 c;
    private final C3419zb d;
    private final A1 e;
    private final C3389xf f;
    private final com.ironsource.mediationsdk.adquality.a g;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Gd f3071a;
        private C3366w9 b;
        private V2 c;
        private C3419zb d;
        private A1 e;
        private C3389xf f;
        private com.ironsource.mediationsdk.adquality.a g;

        public a() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public final a a(Gd gd, C3366w9 c3366w9, V2 v2, C3419zb c3419zb, A1 a1, C3389xf c3389xf, com.ironsource.mediationsdk.adquality.a aVar) {
            return new a(gd, c3366w9, v2, c3419zb, a1, c3389xf, aVar);
        }

        public final Gd b() {
            return this.f3071a;
        }

        public final C3366w9 c() {
            return this.b;
        }

        public final V2 d() {
            return this.c;
        }

        public final C3419zb e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f3071a, aVar.f3071a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e) && Intrinsics.areEqual(this.f, aVar.f) && Intrinsics.areEqual(this.g, aVar.g);
        }

        public final A1 f() {
            return this.e;
        }

        public final C3389xf g() {
            return this.f;
        }

        public final com.ironsource.mediationsdk.adquality.a h() {
            return this.g;
        }

        public int hashCode() {
            Gd gd = this.f3071a;
            int hashCode = (gd == null ? 0 : gd.hashCode()) * 31;
            C3366w9 c3366w9 = this.b;
            int hashCode2 = (hashCode + (c3366w9 == null ? 0 : c3366w9.hashCode())) * 31;
            V2 v2 = this.c;
            int hashCode3 = (hashCode2 + (v2 == null ? 0 : v2.hashCode())) * 31;
            C3419zb c3419zb = this.d;
            int hashCode4 = (hashCode3 + (c3419zb == null ? 0 : c3419zb.hashCode())) * 31;
            A1 a1 = this.e;
            int hashCode5 = (hashCode4 + (a1 == null ? 0 : a1.hashCode())) * 31;
            C3389xf c3389xf = this.f;
            int hashCode6 = (hashCode5 + (c3389xf == null ? 0 : c3389xf.hashCode())) * 31;
            com.ironsource.mediationsdk.adquality.a aVar = this.g;
            return hashCode6 + (aVar != null ? aVar.hashCode() : 0);
        }

        public final com.ironsource.mediationsdk.adquality.a i() {
            return this.g;
        }

        public final A1 j() {
            return this.e;
        }

        public final V2 k() {
            return this.c;
        }

        public final C3366w9 l() {
            return this.b;
        }

        public final C3419zb m() {
            return this.d;
        }

        public final Gd n() {
            return this.f3071a;
        }

        public final C3389xf o() {
            return this.f;
        }

        public String toString() {
            return "Builder(rewardedVideoConfigurations=" + this.f3071a + ", interstitialConfigurations=" + this.b + ", bannerConfigurations=" + this.c + ", nativeAdConfigurations=" + this.d + ", applicationConfigurations=" + this.e + ", testSuiteSettings=" + this.f + ", adQualityConfigurations=" + this.g + ")";
        }

        public a(Gd gd, C3366w9 c3366w9, V2 v2, C3419zb c3419zb, A1 a1, C3389xf c3389xf, com.ironsource.mediationsdk.adquality.a aVar) {
            this.f3071a = gd;
            this.b = c3366w9;
            this.c = v2;
            this.d = c3419zb;
            this.e = a1;
            this.f = c3389xf;
            this.g = aVar;
        }

        public static /* synthetic */ a a(a aVar, Gd gd, C3366w9 c3366w9, V2 v2, C3419zb c3419zb, A1 a1, C3389xf c3389xf, com.ironsource.mediationsdk.adquality.a aVar2, int i, Object obj) {
            if ((i & 1) != 0) {
                gd = aVar.f3071a;
            }
            if ((i & 2) != 0) {
                c3366w9 = aVar.b;
            }
            if ((i & 4) != 0) {
                v2 = aVar.c;
            }
            if ((i & 8) != 0) {
                c3419zb = aVar.d;
            }
            if ((i & 16) != 0) {
                a1 = aVar.e;
            }
            if ((i & 32) != 0) {
                c3389xf = aVar.f;
            }
            if ((i & 64) != 0) {
                aVar2 = aVar.g;
            }
            C3389xf c3389xf2 = c3389xf;
            com.ironsource.mediationsdk.adquality.a aVar3 = aVar2;
            A1 a12 = a1;
            V2 v22 = v2;
            return aVar.a(gd, c3366w9, v22, c3419zb, a12, c3389xf2, aVar3);
        }

        public final void b(Gd gd) {
            this.f3071a = gd;
        }

        public final void a(C3389xf c3389xf) {
            this.f = c3389xf;
        }

        public final void b(C3366w9 c3366w9) {
            this.b = c3366w9;
        }

        public final a a(Gd gd) {
            this.f3071a = gd;
            return this;
        }

        public final void b(V2 v2) {
            this.c = v2;
        }

        public final a a(C3366w9 c3366w9) {
            this.b = c3366w9;
            return this;
        }

        public final void b(C3419zb c3419zb) {
            this.d = c3419zb;
        }

        public final a a(V2 v2) {
            this.c = v2;
            return this;
        }

        public final void b(A1 a1) {
            this.e = a1;
        }

        public final a a(C3419zb c3419zb) {
            this.d = c3419zb;
            return this;
        }

        public final void b(com.ironsource.mediationsdk.adquality.a aVar) {
            this.g = aVar;
        }

        public final a a(A1 a1) {
            this.e = a1;
            return this;
        }

        public final a b(C3389xf c3389xf) {
            this.f = c3389xf;
            return this;
        }

        public final a a(com.ironsource.mediationsdk.adquality.a aVar) {
            this.g = aVar;
            return this;
        }

        public /* synthetic */ a(Gd gd, C3366w9 c3366w9, V2 v2, C3419zb c3419zb, A1 a1, C3389xf c3389xf, com.ironsource.mediationsdk.adquality.a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : gd, (i & 2) != 0 ? null : c3366w9, (i & 4) != 0 ? null : v2, (i & 8) != 0 ? null : c3419zb, (i & 16) != 0 ? null : a1, (i & 32) != 0 ? null : c3389xf, (i & 64) != 0 ? null : aVar);
        }

        public final U3 a() {
            return new U3(this.f3071a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }
    }

    public /* synthetic */ U3(Gd gd, C3366w9 c3366w9, V2 v2, C3419zb c3419zb, A1 a1, C3389xf c3389xf, com.ironsource.mediationsdk.adquality.a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(gd, c3366w9, v2, c3419zb, a1, c3389xf, aVar);
    }

    public final com.ironsource.mediationsdk.adquality.a a() {
        return this.g;
    }

    public final A1 b() {
        return this.e;
    }

    public final V2 c() {
        return this.c;
    }

    public final C3366w9 d() {
        return this.b;
    }

    public final C3419zb e() {
        return this.d;
    }

    public final Gd f() {
        return this.f3070a;
    }

    public final C3389xf g() {
        return this.f;
    }

    public String toString() {
        return "configurations(\n" + this.f3070a + "\n" + this.b + "\n" + this.c + "\n" + this.d + ")";
    }

    private U3(Gd gd, C3366w9 c3366w9, V2 v2, C3419zb c3419zb, A1 a1, C3389xf c3389xf, com.ironsource.mediationsdk.adquality.a aVar) {
        this.f3070a = gd;
        this.b = c3366w9;
        this.c = v2;
        this.d = c3419zb;
        this.e = a1;
        this.f = c3389xf;
        this.g = aVar;
    }
}
