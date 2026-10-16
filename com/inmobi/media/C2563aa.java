package com.inmobi.media;

import com.inmobi.commons.core.configs.SignalsConfig;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.aa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2563aa {

    /* renamed from: a, reason: collision with root package name */
    public final String f2519a;
    public final String b;
    public final SignalsConfig.NovatiqConfig c;

    public C2563aa(String hyperId, String spHost, SignalsConfig.NovatiqConfig novatiqConfig) {
        Intrinsics.checkNotNullParameter(hyperId, "hyperId");
        Intrinsics.checkNotNullParameter("i6i", "sspId");
        Intrinsics.checkNotNullParameter(spHost, "spHost");
        Intrinsics.checkNotNullParameter("inmobi", "pubId");
        Intrinsics.checkNotNullParameter(novatiqConfig, "novatiqConfig");
        this.f2519a = hyperId;
        this.b = spHost;
        this.c = novatiqConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2563aa)) {
            return false;
        }
        C2563aa c2563aa = (C2563aa) obj;
        return Intrinsics.areEqual(this.f2519a, c2563aa.f2519a) && Intrinsics.areEqual("i6i", "i6i") && Intrinsics.areEqual(this.b, c2563aa.b) && Intrinsics.areEqual("inmobi", "inmobi") && Intrinsics.areEqual(this.c, c2563aa.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((((this.b.hashCode() + (((this.f2519a.hashCode() * 31) + 102684) * 31)) * 31) - 1183962098) * 31);
    }

    public final String toString() {
        return "NovatiqData(hyperId=" + this.f2519a + ", sspId=i6i, spHost=" + this.b + ", pubId=inmobi, novatiqConfig=" + this.c + ')';
    }
}
