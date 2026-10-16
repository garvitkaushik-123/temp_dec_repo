package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbmw extends zzayt implements zzbmy {
    zzbmw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbmy
    public final void zze(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmy
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmy
    public final void zzg(zzbms zzbmsVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbmsVar);
        zzdb(1, zza);
    }
}
