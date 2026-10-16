package com.fyber.inneractive.sdk.player.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final o[] f1519a;

    public b(ArrayList arrayList) {
        o[] oVarArr = new o[arrayList.size()];
        this.f1519a = oVarArr;
        arrayList.toArray(oVarArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f1519a, ((b) obj).f1519a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1519a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1519a.length);
        for (o oVar : this.f1519a) {
            parcel.writeParcelable(oVar, 0);
        }
    }

    public b(Parcel parcel) {
        this.f1519a = new o[parcel.readInt()];
        int i = 0;
        while (true) {
            o[] oVarArr = this.f1519a;
            if (i >= oVarArr.length) {
                return;
            }
            oVarArr[i] = (o) parcel.readParcelable(o.class.getClassLoader());
            i++;
        }
    }
}
