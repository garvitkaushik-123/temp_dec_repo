package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbaz;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbuc;
import com.google.android.gms.internal.ads.zzbwi;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbv extends zzayt implements zzbx {
    zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzA() throws RemoteException {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzB() throws RemoteException {
        zzdb(11, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzC() throws RemoteException {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzD(zzbh zzbhVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbhVar);
        zzdb(20, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzE(zzbk zzbkVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbkVar);
        zzdb(7, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzF(zzcb zzcbVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzG(zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzrVar);
        zzdb(13, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzH(zzco zzcoVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzcoVar);
        zzdb(8, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzI(zzbaz zzbazVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbazVar);
        zzdb(40, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzJ(zzx zzxVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzK(zzcv zzcvVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzcvVar);
        zzdb(45, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzL(zzeh zzehVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzM(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayv.zza;
        zza.writeInt(z ? 1 : 0);
        zzdb(34, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzN(zzbtz zzbtzVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzO(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayv.zza;
        zza.writeInt(z ? 1 : 0);
        zzdb(22, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzP(zzbdz zzbdzVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzQ(zzdt zzdtVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzdtVar);
        zzdb(42, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzR(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzdb(48, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzS(zzbuc zzbucVar, String str) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzT(String str) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzU(zzbwi zzbwiVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzV(String str) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzW(zzgc zzgcVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzgcVar);
        zzdb(29, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzY(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(44, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzZ() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzaa() throws RemoteException {
        Parcel zzda = zzda(46, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzab() throws RemoteException {
        Parcel zzda = zzda(23, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzac() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzad(zzm zzmVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzmVar);
        Parcel zzda = zzda(4, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzae(zzcs zzcsVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long zzc() throws RemoteException {
        Parcel zzda = zzda(47, zza());
        long readLong = zzda.readLong();
        zzda.recycle();
        return readLong;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzr zzh() throws RemoteException {
        Parcel zzda = zzda(12, zza());
        zzr zzrVar = (zzr) zzayv.zza(zzda, zzr.CREATOR);
        zzda.recycle();
        return zzrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzbk zzj() throws RemoteException {
        zzbk zzbiVar;
        Parcel zzda = zzda(33, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzbiVar = queryLocalInterface instanceof zzbk ? (zzbk) queryLocalInterface : new zzbi(readStrongBinder);
        }
        zzda.recycle();
        return zzbiVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzco zzk() throws RemoteException {
        zzco zzcmVar;
        Parcel zzda = zzda(32, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzcmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzcmVar = queryLocalInterface instanceof zzco ? (zzco) queryLocalInterface : new zzcm(readStrongBinder);
        }
        zzda.recycle();
        return zzcmVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzea zzl() throws RemoteException {
        zzea zzdyVar;
        Parcel zzda = zzda(41, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzdyVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzdyVar = queryLocalInterface instanceof zzea ? (zzea) queryLocalInterface : new zzdy(readStrongBinder);
        }
        zzda.recycle();
        return zzdyVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzed zzm() throws RemoteException {
        zzed zzebVar;
        Parcel zzda = zzda(26, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzebVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzebVar = queryLocalInterface instanceof zzed ? (zzed) queryLocalInterface : new zzeb(readStrongBinder);
        }
        zzda.recycle();
        return zzebVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzo() throws RemoteException {
        Parcel zzda = zzda(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzs() throws RemoteException {
        Parcel zzda = zzda(31, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzt() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzu() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzy() throws RemoteException {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzz(zzm zzmVar, zzbn zzbnVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, zzbnVar);
        zzdb(43, zza);
    }
}
