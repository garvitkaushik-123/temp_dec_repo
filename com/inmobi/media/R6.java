package com.inmobi.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class R6 implements Parcelable {
    public static final P6 CREATOR = new P6();

    /* renamed from: a, reason: collision with root package name */
    public final S6 f2415a;
    public final String b;
    public final int c;
    public final long d;
    public final Lazy e;
    public int f;
    public String g;

    public R6(S6 landingPageTelemetryMetaData, String urlType, int i, long j) {
        Intrinsics.checkNotNullParameter(landingPageTelemetryMetaData, "landingPageTelemetryMetaData");
        Intrinsics.checkNotNullParameter(urlType, "urlType");
        this.f2415a = landingPageTelemetryMetaData;
        this.b = urlType;
        this.c = i;
        this.d = j;
        this.e = LazyKt.lazy(Q6.f2407a);
        this.f = -1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof R6)) {
            return false;
        }
        R6 r6 = (R6) obj;
        return Intrinsics.areEqual(this.f2415a, r6.f2415a) && Intrinsics.areEqual(this.b, r6.b) && this.c == r6.c && this.d == r6.d;
    }

    public final int hashCode() {
        return Long.hashCode(this.d) + ((Integer.hashCode(this.c) + ((this.b.hashCode() + (this.f2415a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "LandingPageTelemetryControlInfo(landingPageTelemetryMetaData=" + this.f2415a + ", urlType=" + this.b + ", counter=" + this.c + ", startTime=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.f2415a.f2426a);
        parcel.writeString(this.f2415a.b);
        parcel.writeString(this.f2415a.c);
        parcel.writeString(this.f2415a.d);
        parcel.writeString(this.f2415a.e);
        parcel.writeString(this.f2415a.f);
        parcel.writeString(this.f2415a.g);
        parcel.writeByte(this.f2415a.h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f2415a.i);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
    }

    public /* synthetic */ R6(S6 s6, String str, int i, int i2) {
        this(s6, str, (i2 & 4) != 0 ? 0 : i, SystemClock.elapsedRealtime());
    }
}
