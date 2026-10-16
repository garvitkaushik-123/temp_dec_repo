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
public final class zznz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznz> CREATOR = new zzoa();
    private zzpb zza;
    private zzqq zzb;

    private zznz() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zznz) {
            zznz zznzVar = (zznz) obj;
            if (Objects.equal(this.zza, zznzVar.zza) && Objects.equal(this.zzb, zznzVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzpb zzpbVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzpbVar == null ? null : zzpbVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zznz(IBinder iBinder, zzqq zzqqVar) {
        zzpb zzozVar;
        if (iBinder == null) {
            zzozVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IResultListener");
            zzozVar = queryLocalInterface instanceof zzpb ? (zzpb) queryLocalInterface : new zzoz(iBinder);
        }
        this.zza = zzozVar;
        this.zzb = zzqqVar;
    }

    /* synthetic */ zznz(zzny zznyVar) {
    }
}
