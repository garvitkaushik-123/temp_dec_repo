package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Jb extends U {
    private final String s;
    private final List<NetworkSettings> t;
    private final C3419zb u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Jb(String str, List<? extends NetworkSettings> list, C3419zb configs) {
        super(IronSource.AD_UNIT.NATIVE_AD, str, list, configs.d(), configs.b(), (int) (configs.c() / 1000), configs.a(), configs.f(), -1, new N0(N0.a.MANUAL, configs.d().j(), configs.d().b(), -1L), new H0(-1L), configs.h(), configs.i(), configs.k(), configs.j(), false, 32768, null);
        Intrinsics.checkNotNullParameter(configs, "configs");
        this.s = str;
        this.t = list;
        this.u = configs;
    }

    public final Jb a(String str, List<? extends NetworkSettings> list, C3419zb configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new Jb(str, list, configs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Jb)) {
            return false;
        }
        Jb jb = (Jb) obj;
        return Intrinsics.areEqual(this.s, jb.s) && Intrinsics.areEqual(this.t, jb.t) && Intrinsics.areEqual(this.u, jb.u);
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
        return "NativeAdManagerData(userId=" + this.s + ", providerList=" + this.t + ", configs=" + this.u + ")";
    }

    public final C3419zb u() {
        return this.u;
    }

    public final C3419zb v() {
        return this.u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Jb a(Jb jb, String str, List list, C3419zb c3419zb, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jb.s;
        }
        if ((i & 2) != 0) {
            list = jb.t;
        }
        if ((i & 4) != 0) {
            c3419zb = jb.u;
        }
        return jb.a(str, list, c3419zb);
    }
}
