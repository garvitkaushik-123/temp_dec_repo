package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzcc extends zzayt implements zzce {
    zzcc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloadCallback");
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void zze(zzfv zzfvVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzfvVar);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void zzf(zzfv zzfvVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzfvVar);
        zzdb(2, zza);
    }
}
