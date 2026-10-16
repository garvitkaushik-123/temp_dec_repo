package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public abstract class zzx extends com.google.android.gms.internal.nearby.zzb implements zzy {
    public zzx() {
        super("com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        boolean zzg = com.google.android.gms.internal.nearby.zzc.zzg(parcel);
        com.google.android.gms.internal.nearby.zzc.zzc(parcel);
        zzd(zzg);
        return true;
    }
}
