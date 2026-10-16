package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbau extends zzayt implements zzbaw {
    zzbau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final long zze() throws RemoteException {
        Parcel zzda = zzda(9, zza());
        long readLong = zzda.readLong();
        zzda.recycle();
        return readLong;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final com.google.android.gms.ads.internal.client.zzbx zzf() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final com.google.android.gms.ads.internal.client.zzea zzg() throws RemoteException {
        Parcel zzda = zzda(5, zza());
        com.google.android.gms.ads.internal.client.zzea zzb = com.google.android.gms.ads.internal.client.zzdz.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final String zzh() throws RemoteException {
        Parcel zzda = zzda(8, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzi(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayv.zza;
        zza.writeInt(z ? 1 : 0);
        zzdb(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzj(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzdtVar);
        zzdb(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzk(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzdb(10, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzl(IObjectWrapper iObjectWrapper, zzbbd zzbbdVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbbdVar);
        zzdb(4, zza);
    }
}
