package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfps extends zzayt implements IInterface {
    zzfps(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfpq zze(zzfpo zzfpoVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzfpoVar);
        Parcel zzda = zzda(1, zza);
        zzfpq zzfpqVar = (zzfpq) zzayv.zza(zzda, zzfpq.CREATOR);
        zzda.recycle();
        return zzfpqVar;
    }

    public final zzfpz zzf(zzfpx zzfpxVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzfpxVar);
        Parcel zzda = zzda(3, zza);
        zzfpz zzfpzVar = (zzfpz) zzayv.zza(zzda, zzfpz.CREATOR);
        zzda.recycle();
        return zzfpzVar;
    }

    public final void zzg(zzfpl zzfplVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzfplVar);
        zzdb(2, zza);
    }
}
