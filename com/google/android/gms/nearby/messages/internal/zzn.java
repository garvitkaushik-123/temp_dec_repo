package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public abstract class zzn extends com.google.android.gms.internal.nearby.zzb implements zzo {
    public zzn() {
        super("com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            com.google.android.gms.internal.nearby.zzc.zzc(parcel);
        } else if (i == 2) {
            com.google.android.gms.internal.nearby.zzc.zzc(parcel);
        } else {
            if (i != 4) {
                return false;
            }
            ArrayList createTypedArrayList = parcel.createTypedArrayList(Update.CREATOR);
            com.google.android.gms.internal.nearby.zzc.zzc(parcel);
            zzd(createTypedArrayList);
        }
        return true;
    }
}
