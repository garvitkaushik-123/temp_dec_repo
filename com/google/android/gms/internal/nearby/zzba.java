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
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();
    private zzdm zza;

    private zzba() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzba) {
            return Objects.equal(this.zza, ((zzba) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zzba(IBinder iBinder) {
        zzdm zzdkVar;
        if (iBinder == null) {
            zzdkVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IIntCallback");
            zzdkVar = queryLocalInterface instanceof zzdm ? (zzdm) queryLocalInterface : new zzdk(iBinder);
        }
        this.zza = zzdkVar;
    }

    /* synthetic */ zzba(zzaz zzazVar) {
    }
}
