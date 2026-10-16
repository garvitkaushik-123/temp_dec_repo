package com.inmobi.media;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Z implements Parcelable {
    public static final Parcelable.Creator<Z> CREATOR = new Y();

    /* renamed from: a, reason: collision with root package name */
    public final long f2501a;
    public final String b;
    public Map c;
    public String d;
    public final String e;
    public final String f;
    public String g;
    public String h;
    public String i;
    public boolean j;
    public String k;

    public Z(long j, String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this.h = "";
        this.i = "activity";
        this.f2501a = j;
        this.b = str;
        this.e = str2;
        this.b = str == null ? "" : str;
        this.f = str3;
    }

    public static /* synthetic */ void c() {
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void n() {
    }

    public final String d() {
        String str = this.g;
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Z)) {
            return false;
        }
        Z z = (Z) obj;
        return this.f2501a == z.f2501a && Intrinsics.areEqual(this.i, z.i) && Intrinsics.areEqual(this.b, z.b) && Intrinsics.areEqual(this.e, z.e);
    }

    public final Map<String, String> f() {
        return this.c;
    }

    public final long g() {
        return this.f2501a;
    }

    public final String h() {
        return "im";
    }

    public int hashCode() {
        long j = this.f2501a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.e;
        return this.i.hashCode() + ((i + (str != null ? str.hashCode() : 0)) * 30);
    }

    public final String i() {
        return this.d;
    }

    public final String j() {
        return this.i;
    }

    public final long l() {
        return this.f2501a;
    }

    public final String m() {
        return this.f;
    }

    public final String o() {
        return this.b;
    }

    public final boolean p() {
        return this.j;
    }

    public String toString() {
        return String.valueOf(this.f2501a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.f2501a);
        dest.writeString(this.i);
        dest.writeString(this.e);
    }

    public final String b() {
        return this.e;
    }

    public final void a(Map<String, String> map) {
        this.c = map;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.i = str;
    }

    public final String a() {
        return this.h;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.h = str;
    }

    public Z(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this.h = "";
        String str = "activity";
        this.i = "activity";
        this.f2501a = parcel.readLong();
        String readString = parcel.readString();
        if (readString != null && !Intrinsics.areEqual(readString, "activity") && Intrinsics.areEqual(readString, "others")) {
            str = "others";
        }
        this.i = str;
        this.e = parcel.readString();
    }
}
