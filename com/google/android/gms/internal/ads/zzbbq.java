package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbbq extends zzayt implements IInterface {
    zzbbq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbbo zzbboVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbboVar);
        Parcel zzda = zzda(3, zza);
        long readLong = zzda.readLong();
        zzda.recycle();
        return readLong;
    }

    public final zzbbl zzf(zzbbo zzbboVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbboVar);
        Parcel zzda = zzda(1, zza);
        zzbbl zzbblVar = (zzbbl) zzayv.zza(zzda, zzbbl.CREATOR);
        zzda.recycle();
        return zzbblVar;
    }

    public final zzbbl zzg(zzbbo zzbboVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbboVar);
        Parcel zzda = zzda(2, zza);
        zzbbl zzbblVar = (zzbbl) zzayv.zza(zzda, zzbbl.CREATOR);
        zzda.recycle();
        return zzbblVar;
    }
}
