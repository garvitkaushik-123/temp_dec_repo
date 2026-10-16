package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class S6 {

    /* renamed from: a, reason: collision with root package name */
    public final long f2426a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final boolean h;
    public final String i;

    public S6(long j, String impressionId, String placementType, String adType, String markupType, String creativeType, String metaDataBlob, boolean z, String landingScheme) {
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(markupType, "markupType");
        Intrinsics.checkNotNullParameter(creativeType, "creativeType");
        Intrinsics.checkNotNullParameter(metaDataBlob, "metaDataBlob");
        Intrinsics.checkNotNullParameter(landingScheme, "landingScheme");
        this.f2426a = j;
        this.b = impressionId;
        this.c = placementType;
        this.d = adType;
        this.e = markupType;
        this.f = creativeType;
        this.g = metaDataBlob;
        this.h = z;
        this.i = landingScheme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S6)) {
            return false;
        }
        S6 s6 = (S6) obj;
        return this.f2426a == s6.f2426a && Intrinsics.areEqual(this.b, s6.b) && Intrinsics.areEqual(this.c, s6.c) && Intrinsics.areEqual(this.d, s6.d) && Intrinsics.areEqual(this.e, s6.e) && Intrinsics.areEqual(this.f, s6.f) && Intrinsics.areEqual(this.g, s6.g) && this.h == s6.h && Intrinsics.areEqual(this.i, s6.i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (Long.hashCode(this.f2426a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.h;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return this.i.hashCode() + ((hashCode + i) * 31);
    }

    public final String toString() {
        return "LandingPageTelemetryMetaData(placementId=" + this.f2426a + ", impressionId=" + this.b + ", placementType=" + this.c + ", adType=" + this.d + ", markupType=" + this.e + ", creativeType=" + this.f + ", metaDataBlob=" + this.g + ", isRewarded=" + this.h + ", landingScheme=" + this.i + ')';
    }
}
