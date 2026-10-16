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
public final class zzbi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbi> CREATOR = new zzbj();
    private zzcy zza;

    private zzbi() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbi) {
            return Objects.equal(this.zza, ((zzbi) obj).zza);
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

    zzbi(IBinder iBinder) {
        zzcy zzcwVar;
        if (iBinder == null) {
            zzcwVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
            zzcwVar = queryLocalInterface instanceof zzcy ? (zzcy) queryLocalInterface : new zzcw(iBinder);
        }
        this.zza = zzcwVar;
    }

    /* synthetic */ zzbi(zzbh zzbhVar) {
    }
}
