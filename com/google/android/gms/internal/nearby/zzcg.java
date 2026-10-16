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
public final class zzcg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcg> CREATOR = new zzch();
    private zzdy zza;
    private zzdv zzb;

    private zzcg() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcg) {
            zzcg zzcgVar = (zzcg) obj;
            if (Objects.equal(this.zzb, zzcgVar.zzb) && Objects.equal(this.zza, zzcgVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdv zzdvVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdvVar == null ? null : zzdvVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zzcg(IBinder iBinder, IBinder iBinder2) {
        zzdv zzdvVar;
        zzdy zzdyVar = null;
        if (iBinder == null) {
            zzdvVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyHistoryResultListener");
            zzdvVar = queryLocalInterface instanceof zzdv ? (zzdv) queryLocalInterface : new zzdv(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
            zzdyVar = queryLocalInterface2 instanceof zzdy ? (zzdy) queryLocalInterface2 : new zzdw(iBinder2);
        }
        this.zzb = zzdvVar;
        this.zza = zzdyVar;
    }

    /* synthetic */ zzcg(zzcf zzcfVar) {
    }
}
