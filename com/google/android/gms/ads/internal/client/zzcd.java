package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzcd extends zzayu implements zzce {
    public zzcd() {
        super("com.google.android.gms.ads.internal.client.IAdPreloadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzfv zzfvVar = (zzfv) zzayv.zza(parcel, zzfv.CREATOR);
            zzayv.zzd(parcel);
            zze(zzfvVar);
        } else {
            if (i != 2) {
                return false;
            }
            zzfv zzfvVar2 = (zzfv) zzayv.zza(parcel, zzfv.CREATOR);
            zzayv.zzd(parcel);
            zzf(zzfvVar2);
        }
        parcel2.writeNoException();
        return true;
    }
}
