package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzos extends zza implements IInterface {
    zzos(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.uwb.internal.INearbyUwbService");
    }

    public final void zzd(zznz zznzVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zznzVar);
        zzv(1008, zza);
    }

    public final void zze(zzob zzobVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzobVar);
        zzv(1007, zza);
    }

    public final void zzf(zzof zzofVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzofVar);
        zzv(1004, zza);
    }

    public final void zzg(zzoj zzojVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzojVar);
        zzv(1003, zza);
    }

    public final void zzh(zzon zzonVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzonVar);
        zzv(1002, zza);
    }

    public final void zzi(zzpk zzpkVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzpkVar);
        zzv(1001, zza);
    }

    public final void zzj(zzqe zzqeVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzqeVar);
        zzv(1009, zza);
    }

    public final void zzk(zzqi zzqiVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzqiVar);
        zzv(1005, zza);
    }

    public final void zzl(zzqm zzqmVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzqmVar);
        zzv(1006, zza);
    }
}
