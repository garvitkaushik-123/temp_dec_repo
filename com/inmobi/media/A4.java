package com.inmobi.media;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class A4 {

    /* renamed from: a, reason: collision with root package name */
    public final float f2230a;
    public final B4 b;
    public final ArrayList c;

    public A4(float f, B4 b4, ArrayList arrayList) {
        this.f2230a = f;
        this.b = b4;
        this.c = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A4)) {
            return false;
        }
        A4 a4 = (A4) obj;
        return Float.compare(this.f2230a, a4.f2230a) == 0 && Intrinsics.areEqual(this.b, a4.b) && Intrinsics.areEqual(this.c, a4.c);
    }

    public final int hashCode() {
        int hashCode = Float.hashCode(this.f2230a) * 31;
        B4 b4 = this.b;
        int hashCode2 = (hashCode + (b4 == null ? 0 : b4.hashCode())) * 31;
        ArrayList arrayList = this.c;
        return hashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final String toString() {
        return "ExposureMetrics(exposedPercentage=" + this.f2230a + ", visibleRectangle=" + this.b + ", occlusionRectangles=" + this.c + ')';
    }
}
