package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public abstract class zzoq extends zzb implements zzor {
    public zzoq() {
        super("com.google.android.gms.nearby.uwb.internal.IBooleanResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        boolean zzg = zzc.zzg(parcel);
        zzc.zzc(parcel);
        zzd(zzg);
        return true;
    }
}
