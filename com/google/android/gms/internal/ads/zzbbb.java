package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbbb extends zzayt implements zzbbd {
    zzbbb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzb() throws RemoteException {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzc() throws RemoteException {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzd(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zze() throws RemoteException {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzf() throws RemoteException {
        zzdb(1, zza());
    }
}
