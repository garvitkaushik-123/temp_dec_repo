package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class S2 {

    /* renamed from: a, reason: collision with root package name */
    public final Config f2422a;
    public final N2 b;

    public S2(Config config, N2 n2) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f2422a = config;
        this.b = n2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S2)) {
            return false;
        }
        S2 s2 = (S2) obj;
        return Intrinsics.areEqual(this.f2422a, s2.f2422a) && Intrinsics.areEqual(this.b, s2.b);
    }

    public final int hashCode() {
        int hashCode = this.f2422a.hashCode() * 31;
        N2 n2 = this.b;
        return hashCode + (n2 == null ? 0 : n2.hashCode());
    }

    public final String toString() {
        return "ConfigFetchInputs(config=" + this.f2422a + ", listener=" + this.b + ')';
    }
}
