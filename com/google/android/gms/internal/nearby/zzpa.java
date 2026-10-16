package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public abstract class zzpa extends zzb implements zzpb {
    public zzpa() {
        super("com.google.android.gms.nearby.uwb.internal.IResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        int readInt = parcel.readInt();
        zzc.zzc(parcel);
        zzd(readInt);
        return true;
    }
}
