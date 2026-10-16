package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class h extends o {
    public static final Parcelable.Creator<h> CREATOR = new g();
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String[] e;
    public final o[] f;

    public h(String str, boolean z, boolean z2, String[] strArr, o[] oVarArr) {
        super("CTOC");
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = strArr;
        this.f = oVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h.class == obj.getClass()) {
            h hVar = (h) obj;
            if (this.c == hVar.c && this.d == hVar.d && z.a(this.b, hVar.b) && Arrays.equals(this.e, hVar.e) && Arrays.equals(this.f, hVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((((this.c ? 1 : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + (this.d ? 1 : 0)) * 31;
        String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.e);
        parcel.writeInt(this.f.length);
        int i2 = 0;
        while (true) {
            o[] oVarArr = this.f;
            if (i2 >= oVarArr.length) {
                return;
            }
            parcel.writeParcelable(oVarArr[i2], 0);
            i2++;
        }
    }

    public h(Parcel parcel) {
        super("CTOC");
        this.b = parcel.readString();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readByte() != 0;
        this.e = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f = new o[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f[i] = (o) parcel.readParcelable(o.class.getClassLoader());
        }
    }
}
