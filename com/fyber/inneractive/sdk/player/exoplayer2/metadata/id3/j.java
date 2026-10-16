package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes4.dex */
public final class j extends o {
    public static final Parcelable.Creator<j> CREATOR = new i();
    public final String b;
    public final String c;
    public final String d;

    public j(String str, String str2, String str3) {
        super("COMM");
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            j jVar = (j) obj;
            if (z.a(this.c, jVar.c) && z.a(this.b, jVar.b) && z.a(this.d, jVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.b;
        int hashCode = ((str != null ? str.hashCode() : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1522a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }

    public j(Parcel parcel) {
        super("COMM");
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
