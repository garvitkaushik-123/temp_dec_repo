package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbww extends zzayt implements zzbwy {
    zzbww(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zze() throws RemoteException {
        zzdb(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzf() throws RemoteException {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzg() throws RemoteException {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzh(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdb(4, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzj() throws RemoteException {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzk(zzbws zzbwsVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbwsVar);
        zzdb(3, zza);
    }
}
