package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzqi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqi> CREATOR = new zzqj();
    private zzpb zza;
    private zzpy zzb;
    private zzoy zzc;

    private zzqi() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqi) {
            zzqi zzqiVar = (zzqi) obj;
            if (Objects.equal(this.zza, zzqiVar.zza) && Objects.equal(this.zzb, zzqiVar.zzb) && Objects.equal(this.zzc, zzqiVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzpb zzpbVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzpbVar == null ? null : zzpbVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zzqi(IBinder iBinder, zzpy zzpyVar, IBinder iBinder2) {
        zzpb zzozVar;
        zzoy zzoyVar = null;
        if (iBinder == null) {
            zzozVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IResultListener");
            zzozVar = queryLocalInterface instanceof zzpb ? (zzpb) queryLocalInterface : new zzoz(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IRangingSessionCallback");
            zzoyVar = queryLocalInterface2 instanceof zzoy ? (zzoy) queryLocalInterface2 : new zzow(iBinder2);
        }
        this.zza = zzozVar;
        this.zzb = zzpyVar;
        this.zzc = zzoyVar;
    }

    /* synthetic */ zzqi(zzqh zzqhVar) {
    }
}
