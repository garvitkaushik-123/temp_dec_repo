package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbwg extends zzayt implements zzbwi {
    zzbwg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zze(zzbwc zzbwcVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbwcVar);
        zzdb(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzf() throws RemoteException {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdb(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzh() throws RemoteException {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzi() throws RemoteException {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzj() throws RemoteException {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzk() throws RemoteException {
        zzdb(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzl() throws RemoteException {
        zzdb(3, zza());
    }
}
