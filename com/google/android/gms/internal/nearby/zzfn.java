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
public final class zzfn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfn> CREATOR = new zzfo();
    private zzkj zza;
    private long zzb;

    private zzfn() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfn) {
            zzfn zzfnVar = (zzfn) obj;
            if (Objects.equal(this.zza, zzfnVar.zza) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(zzfnVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkj zzkjVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzkjVar == null ? null : zzkjVar.asBinder(), false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zzfn(IBinder iBinder, long j) {
        zzkj zzkhVar;
        if (iBinder == null) {
            zzkhVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzkhVar = queryLocalInterface instanceof zzkj ? (zzkj) queryLocalInterface : new zzkh(iBinder);
        }
        this.zza = zzkhVar;
        this.zzb = j;
    }

    /* synthetic */ zzfn(zzfm zzfmVar) {
    }
}
