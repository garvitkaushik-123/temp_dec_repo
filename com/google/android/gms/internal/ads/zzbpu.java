package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbpu extends zzayt implements zzbpw {
    zzbpu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zze() throws RemoteException {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzf() throws RemoteException {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdb(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(23, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzi(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        zzdb(22, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzj(int i) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(24, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdb(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzm() throws RemoteException {
        zzdb(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzn() throws RemoteException {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzo() throws RemoteException {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzp() throws RemoteException {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzq(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzdb(9, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzr(zzbhj zzbhjVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbhjVar);
        zza.writeString(str);
        zzdb(10, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzs(zzbwo zzbwoVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzt(zzbws zzbwsVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbwsVar);
        zzdb(16, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzu() throws RemoteException {
        zzdb(25, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzv() throws RemoteException {
        zzdb(18, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzw() throws RemoteException {
        zzdb(11, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzx() throws RemoteException {
        zzdb(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzy() throws RemoteException {
        zzdb(20, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzz() throws RemoteException {
        zzdb(13, zza());
    }
}
