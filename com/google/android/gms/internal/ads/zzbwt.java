package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbwt extends zzayt implements zzbwv {
    zzbwt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final long zzb() throws RemoteException {
        Parcel zzda = zzda(17, zza());
        long readLong = zzda.readLong();
        zzda.recycle();
        return readLong;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final Bundle zzc() throws RemoteException {
        Parcel zzda = zzda(9, zza());
        Bundle bundle = (Bundle) zzayv.zza(zzda, Bundle.CREATOR);
        zzda.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final com.google.android.gms.ads.internal.client.zzea zzd() throws RemoteException {
        Parcel zzda = zzda(12, zza());
        com.google.android.gms.ads.internal.client.zzea zzb = com.google.android.gms.ads.internal.client.zzdz.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final zzbws zze() throws RemoteException {
        zzbws zzbwqVar;
        Parcel zzda = zzda(11, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbwqVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzbwqVar = queryLocalInterface instanceof zzbws ? (zzbws) queryLocalInterface : new zzbwq(readStrongBinder);
        }
        zzda.recycle();
        return zzbwqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final String zzf() throws RemoteException {
        Parcel zzda = zzda(16, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final String zzg() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzh(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbxc zzbxcVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, zzbxcVar);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzi(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbxc zzbxcVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, zzbxcVar);
        zzdb(14, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzj(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayv.zza;
        zza.writeInt(z ? 1 : 0);
        zzdb(15, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzk(com.google.android.gms.ads.internal.client.zzdq zzdqVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzdqVar);
        zzdb(8, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzl(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzdtVar);
        zzdb(13, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzm(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzdb(18, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzn(zzbwy zzbwyVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbwyVar);
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzo(zzbxj zzbxjVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbxjVar);
        zzdb(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzq(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final boolean zzr() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzs(zzbxd zzbxdVar) throws RemoteException {
        throw null;
    }
}
