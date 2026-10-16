package com.inmobi.media;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Sd {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2430a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final List f;
    public final double g;

    public Sd(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List priorityEventsList, double d) {
        Intrinsics.checkNotNullParameter(priorityEventsList, "priorityEventsList");
        this.f2430a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = priorityEventsList;
        this.g = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sd)) {
            return false;
        }
        Sd sd = (Sd) obj;
        return this.f2430a == sd.f2430a && this.b == sd.b && this.c == sd.c && this.d == sd.d && this.e == sd.e && Intrinsics.areEqual(this.f, sd.f) && Double.compare(this.g, sd.g) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public final int hashCode() {
        boolean z = this.f2430a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.b;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.c;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.d;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z2 = this.e;
        return Double.hashCode(this.g) + ((this.f.hashCode() + ((i7 + (z2 ? 1 : z2 ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        return "TelemetryConfigMetaData(isTelemetryEnabled=" + this.f2430a + ", isImageEnabled=" + this.b + ", isGIFEnabled=" + this.c + ", isVideoEnabled=" + this.d + ", isGeneralEventsDisabled=" + this.e + ", priorityEventsList=" + this.f + ", samplingFactor=" + this.g + ')';
    }
}
