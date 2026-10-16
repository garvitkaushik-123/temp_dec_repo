package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes4.dex */
public final class s extends o {
    public static final Parcelable.Creator<s> CREATOR = new r();
    public final String b;
    public final String c;

    public s(String str, String str2, String str3) {
        super(str);
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && s.class == obj.getClass()) {
            s sVar = (s) obj;
            if (this.f1522a.equals(sVar.f1522a) && z.a(this.b, sVar.b) && z.a(this.c, sVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f1522a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1522a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public s(Parcel parcel) {
        super(parcel.readString());
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}
