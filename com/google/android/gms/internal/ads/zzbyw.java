package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbyw extends zzayu implements zzbyx {
    public zzbyw() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.readString();
            parcel.readString();
            zzayv.zzd(parcel);
        } else if (i == 2) {
            String readString = parcel.readString();
            zzayv.zzd(parcel);
            zzb(readString);
        } else {
            if (i != 3) {
                return false;
            }
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Bundle bundle = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
            zzayv.zzd(parcel);
            zzc(readString2, readString3, bundle);
        }
        parcel2.writeNoException();
        return true;
    }
}
