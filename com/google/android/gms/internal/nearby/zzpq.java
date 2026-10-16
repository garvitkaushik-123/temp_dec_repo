package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzpq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpq> CREATOR = new zzpr();
    private zzrv zza;
    private int zzb;

    private zzpq() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpq) {
            zzpq zzpqVar = (zzpq) obj;
            if (Objects.equal(this.zza, zzpqVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzpqVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzrv zzb() {
        return this.zza;
    }

    zzpq(zzrv zzrvVar, int i) {
        this.zza = zzrvVar;
        this.zzb = i;
    }
}
