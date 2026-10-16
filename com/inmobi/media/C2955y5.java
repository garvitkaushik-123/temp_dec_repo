package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.y5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2955y5 {

    /* renamed from: a, reason: collision with root package name */
    public final EnumC2560a7 f2761a;
    public final double b;

    public C2955y5(EnumC2560a7 logLevel, double d) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        this.f2761a = logLevel;
        this.b = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2955y5)) {
            return false;
        }
        C2955y5 c2955y5 = (C2955y5) obj;
        return this.f2761a == c2955y5.f2761a && Double.compare(this.b, c2955y5.b) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.b) + (this.f2761a.hashCode() * 31);
    }

    public final String toString() {
        return "LoggerConfiguration(logLevel=" + this.f2761a + ", samplingFactor=" + this.b + ')';
    }
}
