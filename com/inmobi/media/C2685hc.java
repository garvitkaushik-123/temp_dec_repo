package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.hc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2685hc {

    /* renamed from: a, reason: collision with root package name */
    public final Z f2589a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final boolean g;
    public final int h;
    public final T0 i;
    public final C2766mc j;
    public final String k;

    public C2685hc(Z placement, String markupType, String telemetryMetadataBlob, int i, String creativeType, String creativeId, boolean z, int i2, T0 t0, C2766mc c2766mc, String str) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(markupType, "markupType");
        Intrinsics.checkNotNullParameter(telemetryMetadataBlob, "telemetryMetadataBlob");
        Intrinsics.checkNotNullParameter(creativeType, "creativeType");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        this.f2589a = placement;
        this.b = markupType;
        this.c = telemetryMetadataBlob;
        this.d = i;
        this.e = creativeType;
        this.f = creativeId;
        this.g = z;
        this.h = i2;
        this.i = t0;
        this.j = c2766mc;
        this.k = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2685hc)) {
            return false;
        }
        C2685hc c2685hc = (C2685hc) obj;
        return Intrinsics.areEqual(this.f2589a, c2685hc.f2589a) && Intrinsics.areEqual(this.b, c2685hc.b) && Intrinsics.areEqual(this.c, c2685hc.c) && this.d == c2685hc.d && Intrinsics.areEqual(this.e, c2685hc.e) && Intrinsics.areEqual(this.f, c2685hc.f) && this.g == c2685hc.g && this.h == c2685hc.h && Intrinsics.areEqual(this.i, c2685hc.i) && Intrinsics.areEqual(this.j, c2685hc.j) && Intrinsics.areEqual(this.k, c2685hc.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.f.hashCode() + ((this.e.hashCode() + ((Integer.hashCode(this.d) + ((this.c.hashCode() + ((this.b.hashCode() + (this.f2589a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.g;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (Integer.hashCode(this.h) + ((hashCode + i) * 31)) * 31;
        T0 t0 = this.i;
        int hashCode3 = (hashCode2 + (t0 == null ? 0 : t0.hashCode())) * 31;
        C2766mc c2766mc = this.j;
        int hashCode4 = (hashCode3 + (c2766mc == null ? 0 : Integer.hashCode(c2766mc.f2642a))) * 31;
        String str = this.k;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RenderViewMetaData(placement=");
        sb.append(this.f2589a).append(", markupType=").append(this.b).append(", telemetryMetadataBlob=").append(this.c).append(", internetAvailabilityAdRetryCount=").append(this.d).append(", creativeType=").append(this.e).append(", creativeId=").append(this.f).append(", isRewarded=").append(this.g).append(", adIndex=").append(this.h).append(", adUnitTelemetryData=").append(this.i).append(", renderViewTelemetryData=").append(this.j).append(", renderViewId=").append(this.k).append(')');
        return sb.toString();
    }
}
