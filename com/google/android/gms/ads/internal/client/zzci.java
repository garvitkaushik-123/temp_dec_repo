package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbav;
import com.google.android.gms.internal.ads.zzbaw;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbwu;
import com.google.android.gms.internal.ads.zzbwv;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzci extends zzayt implements zzck {
    zzci(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final int zze(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        Parcel zzda = zzda(16, zza);
        int readInt = zzda.readInt();
        zzda.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final Bundle zzf(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        Parcel zzda = zzda(15, zza);
        Bundle bundle = (Bundle) zzayv.zza(zzda, Bundle.CREATOR);
        zzda.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbaw zzg(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(12, zza);
        zzbaw zzb = zzbav.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbaw zzh(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(5, zza);
        zzbaw zzb = zzbav.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbx zzi(String str) throws RemoteException {
        zzbx zzbvVar;
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(11, zza);
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = queryLocalInterface instanceof zzbx ? (zzbx) queryLocalInterface : new zzbv(readStrongBinder);
        }
        zzda.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbx zzj(String str) throws RemoteException {
        zzbx zzbvVar;
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(7, zza);
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = queryLocalInterface instanceof zzbx ? (zzbx) queryLocalInterface : new zzbv(readStrongBinder);
        }
        zzda.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzfv zzk(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        Parcel zzda = zzda(14, zza);
        zzfv zzfvVar = (zzfv) zzayv.zza(zzda, zzfv.CREATOR);
        zzda.recycle();
        return zzfvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbwv zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(13, zza);
        zzbwv zzt = zzbwu.zzt(zzda.readStrongBinder());
        zzda.recycle();
        return zzt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbwv zzm(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(3, zza);
        zzbwv zzt = zzbwu.zzt(zzda.readStrongBinder());
        zzda.recycle();
        return zzt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zzn(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdb(18, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zzo(zzbpq zzbpqVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbpqVar);
        zzdb(8, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zzp(List list, zzce zzceVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzayv.zzg(zza, zzceVar);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzq(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        Parcel zzda = zzda(17, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzr(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        Parcel zzda = zzda(10, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzs(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(4, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzt(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(6, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzu(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(2, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzv(String str, zzfv zzfvVar, zzch zzchVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayv.zze(zza, zzfvVar);
        zzayv.zzg(zza, zzchVar);
        Parcel zzda = zzda(9, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }
}
