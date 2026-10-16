package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbih extends zzayt implements zzbij {
    zzbih(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzA(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, bundle);
        zzdb(15, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzB() throws RemoteException {
        zzdb(28, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzC(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, bundle);
        zzdb(33, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzD(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, bundle);
        zzdb(17, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzE() throws RemoteException {
        zzdb(27, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzF(com.google.android.gms.ads.internal.client.zzdf zzdfVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzdfVar);
        zzdb(26, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzG(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzdtVar);
        zzdb(32, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzH(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzdb(35, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzI(zzbig zzbigVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbigVar);
        zzdb(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final boolean zzJ() throws RemoteException {
        Parcel zzda = zzda(30, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final boolean zzK() throws RemoteException {
        Parcel zzda = zzda(24, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final boolean zzL(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, bundle);
        Parcel zzda = zzda(16, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final double zze() throws RemoteException {
        Parcel zzda = zzda(8, zza());
        double readDouble = zzda.readDouble();
        zzda.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final long zzf() throws RemoteException {
        Parcel zzda = zzda(34, zza());
        long readLong = zzda.readLong();
        zzda.recycle();
        return readLong;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final Bundle zzg() throws RemoteException {
        Parcel zzda = zzda(20, zza());
        Bundle bundle = (Bundle) zzayv.zza(zzda, Bundle.CREATOR);
        zzda.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final com.google.android.gms.ads.internal.client.zzea zzh() throws RemoteException {
        Parcel zzda = zzda(31, zza());
        com.google.android.gms.ads.internal.client.zzea zzb = com.google.android.gms.ads.internal.client.zzdz.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final com.google.android.gms.ads.internal.client.zzed zzi() throws RemoteException {
        Parcel zzda = zzda(11, zza());
        com.google.android.gms.ads.internal.client.zzed zzb = com.google.android.gms.ads.internal.client.zzec.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzbgi zzj() throws RemoteException {
        zzbgi zzbggVar;
        Parcel zzda = zzda(14, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbggVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzbggVar = queryLocalInterface instanceof zzbgi ? (zzbgi) queryLocalInterface : new zzbgg(readStrongBinder);
        }
        zzda.recycle();
        return zzbggVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzbgm zzk() throws RemoteException {
        zzbgm zzbgkVar;
        Parcel zzda = zzda(29, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbgkVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbgkVar = queryLocalInterface instanceof zzbgm ? (zzbgm) queryLocalInterface : new zzbgk(readStrongBinder);
        }
        zzda.recycle();
        return zzbgkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzbgp zzl() throws RemoteException {
        zzbgp zzbgnVar;
        Parcel zzda = zzda(5, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbgnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbgnVar = queryLocalInterface instanceof zzbgp ? (zzbgp) queryLocalInterface : new zzbgn(readStrongBinder);
        }
        zzda.recycle();
        return zzbgnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzda = zzda(19, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzda = zzda(18, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzo() throws RemoteException {
        Parcel zzda = zzda(7, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzp() throws RemoteException {
        Parcel zzda = zzda(4, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzq() throws RemoteException {
        Parcel zzda = zzda(6, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzr() throws RemoteException {
        Parcel zzda = zzda(2, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzs() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzt() throws RemoteException {
        Parcel zzda = zzda(10, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzu() throws RemoteException {
        Parcel zzda = zzda(9, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final List zzv() throws RemoteException {
        Parcel zzda = zzda(3, zza());
        ArrayList zzb = zzayv.zzb(zzda);
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final List zzw() throws RemoteException {
        Parcel zzda = zzda(23, zza());
        ArrayList zzb = zzayv.zzb(zzda);
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzx() throws RemoteException {
        zzdb(22, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzy() throws RemoteException {
        zzdb(13, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzz(com.google.android.gms.ads.internal.client.zzdj zzdjVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzdjVar);
        zzdb(25, zza);
    }
}
