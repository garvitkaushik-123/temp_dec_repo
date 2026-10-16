package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Bd extends U {
    private final String s;
    private final List<NetworkSettings> t;
    private final Gd u;
    private final boolean v;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bd(String str, List<? extends NetworkSettings> list, Gd configs, boolean z) {
        super(r1, str, list, r4, r5, r6, r7, r8, r9, r10, new H0(-1L), configs.l(), configs.f(), configs.o(), configs.n(), false, 32768, null);
        N0 b;
        Intrinsics.checkNotNullParameter(configs, "configs");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        C3241p2 k = configs.k();
        Intrinsics.checkNotNullExpressionValue(k, "configs.rewardedVideoAuctionSettings");
        int g = configs.g();
        int h = configs.h();
        boolean j = configs.j();
        int b2 = configs.b();
        int c = configs.c();
        b = Cd.b(configs, z);
        this.s = str;
        this.t = list;
        this.u = configs;
        this.v = z;
    }

    public final Bd a(String str, List<? extends NetworkSettings> list, Gd configs, boolean z) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new Bd(str, list, configs, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bd)) {
            return false;
        }
        Bd bd = (Bd) obj;
        return Intrinsics.areEqual(this.s, bd.s) && Intrinsics.areEqual(this.t, bd.t) && Intrinsics.areEqual(this.u, bd.u) && this.v == bd.v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.s;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<NetworkSettings> list = this.t;
        int hashCode2 = (((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.u.hashCode()) * 31;
        boolean z = this.v;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode2 + i;
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
        return "RewardedVideoAdDataManager(userId=" + this.s + ", providerList=" + this.t + ", configs=" + this.u + ", isManual=" + this.v + ")";
    }

    public final Gd u() {
        return this.u;
    }

    public final boolean v() {
        return this.v;
    }

    public final Gd w() {
        return this.u;
    }

    public final boolean x() {
        return this.v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Bd a(Bd bd, String str, List list, Gd gd, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bd.s;
        }
        if ((i & 2) != 0) {
            list = bd.t;
        }
        if ((i & 4) != 0) {
            gd = bd.u;
        }
        if ((i & 8) != 0) {
            z = bd.v;
        }
        return bd.a(str, list, gd, z);
    }
}
