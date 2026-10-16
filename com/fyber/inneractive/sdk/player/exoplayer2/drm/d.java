package com.fyber.inneractive.sdk.player.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class d implements Comparator, Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final c[] f1402a;
    public int b;
    public final int c;

    public d(boolean z, c... cVarArr) {
        cVarArr = z ? (c[]) cVarArr.clone() : cVarArr;
        Arrays.sort(cVarArr, this);
        for (int i = 1; i < cVarArr.length; i++) {
            if (cVarArr[i - 1].b.equals(cVarArr[i].b)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + cVarArr[i].b);
            }
        }
        this.f1402a = cVarArr;
        this.c = cVarArr.length;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        c cVar = (c) obj;
        c cVar2 = (c) obj2;
        UUID uuid = com.fyber.inneractive.sdk.player.exoplayer2.b.b;
        return uuid.equals(cVar.b) ? uuid.equals(cVar2.b) ? 0 : 1 : cVar.b.compareTo(cVar2.b);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f1402a, ((d) obj).f1402a);
    }

    public final int hashCode() {
        if (this.b == 0) {
            this.b = Arrays.hashCode(this.f1402a);
        }
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f1402a, 0);
    }

    public d(Parcel parcel) {
        c[] cVarArr = (c[]) parcel.createTypedArray(c.CREATOR);
        this.f1402a = cVarArr;
        this.c = cVarArr.length;
    }
}
