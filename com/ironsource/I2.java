package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class I2 extends U {
    private final String s;
    private final List<NetworkSettings> t;
    private final V2 u;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public I2(String str, List<? extends NetworkSettings> list, V2 configs) {
        super(r1, str, list, r4, r5, r6, r7, r8, -1, r10, new H0(configs.j()), configs.e(), configs.l(), configs.n(), configs.m(), false, 32768, null);
        N0 b;
        Intrinsics.checkNotNullParameter(configs, "configs");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        C3241p2 d = configs.d();
        Intrinsics.checkNotNullExpressionValue(d, "configs.bannerAuctionSettings");
        int a2 = configs.a();
        int b2 = (int) (configs.b() / 1000);
        boolean c = configs.c();
        int f = configs.f();
        b = J2.b(configs);
        this.s = str;
        this.t = list;
        this.u = configs;
    }

    public final I2 a(String str, List<? extends NetworkSettings> list, V2 configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new I2(str, list, configs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I2)) {
            return false;
        }
        I2 i2 = (I2) obj;
        return Intrinsics.areEqual(this.s, i2.s) && Intrinsics.areEqual(this.t, i2.t) && Intrinsics.areEqual(this.u, i2.u);
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
        return "BannerAdManagerData(userId=" + this.s + ", providerList=" + this.t + ", configs=" + this.u + ")";
    }

    public final V2 u() {
        return this.u;
    }

    public final V2 v() {
        return this.u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ I2 a(I2 i2, String str, List list, V2 v2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = i2.s;
        }
        if ((i & 2) != 0) {
            list = i2.t;
        }
        if ((i & 4) != 0) {
            v2 = i2.u;
        }
        return i2.a(str, list, v2);
    }
}
