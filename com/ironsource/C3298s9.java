package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.s9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3298s9 extends U {
    private final String s;
    private final List<NetworkSettings> t;
    private final C3366w9 u;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C3298s9(String str, List<? extends NetworkSettings> list, C3366w9 configs) {
        super(r1, str, list, r4, configs.c(), configs.d(), configs.f(), configs.b(), -1, new N0(N0.a.MANUAL, configs.g().j(), configs.g().b(), -1L), new H0(-1L), configs.h(), configs.k(), configs.m(), configs.l(), false, 32768, null);
        Intrinsics.checkNotNullParameter(configs, "configs");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        C3241p2 g = configs.g();
        Intrinsics.checkNotNullExpressionValue(g, "configs.interstitialAuctionSettings");
        this.s = str;
        this.t = list;
        this.u = configs;
    }

    public final C3298s9 a(String str, List<? extends NetworkSettings> list, C3366w9 configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new C3298s9(str, list, configs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3298s9)) {
            return false;
        }
        C3298s9 c3298s9 = (C3298s9) obj;
        return Intrinsics.areEqual(this.s, c3298s9.s) && Intrinsics.areEqual(this.t, c3298s9.t) && Intrinsics.areEqual(this.u, c3298s9.u);
    }

    public int hashCode() {
        String str = this.s;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<NetworkSettings> list = this.t;
        return ((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.u.hashCode();
    }

    @Override // com.ironsource.U
    public List<NetworkSettings> j() {
        return this.t;
    }

    @Override // com.ironsource.U
    public String o() {
        return this.s;
    }

    public final String s() {
        return this.s;
    }

    public final List<NetworkSettings> t() {
        return this.t;
    }

    public String toString() {
        return "InterstitialAdManagerData(userId=" + this.s + ", providerList=" + this.t + ", configs=" + this.u + ")";
    }

    public final C3366w9 u() {
        return this.u;
    }

    public final C3366w9 v() {
        return this.u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C3298s9 a(C3298s9 c3298s9, String str, List list, C3366w9 c3366w9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c3298s9.s;
        }
        if ((i & 2) != 0) {
            list = c3298s9.t;
        }
        if ((i & 4) != 0) {
            c3366w9 = c3298s9.u;
        }
        return c3298s9.a(str, list, c3366w9);
    }
}
