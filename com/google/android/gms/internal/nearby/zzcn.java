package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public abstract class zzcn extends zzb implements zzco {
    public zzcn() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        boolean zzg = zzc.zzg(parcel);
        zzc.zzc(parcel);
        zzb(status, zzg);
        return true;
    }
}
