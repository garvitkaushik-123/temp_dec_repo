package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbvc extends zzayt implements zzbve {
    zzbvc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zze(zzbvq zzbvqVar, zzbvi zzbviVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbvqVar);
        zzayv.zzg(zza, zzbviVar);
        zzdb(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzf(zzbvq zzbvqVar, zzbvi zzbviVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbvqVar);
        zzayv.zzg(zza, zzbviVar);
        zzdb(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzg(zzbvq zzbvqVar, zzbvi zzbviVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbvqVar);
        zzayv.zzg(zza, zzbviVar);
        zzdb(4, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzh(String str, zzbvi zzbviVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayv.zzg(zza, zzbviVar);
        zzdb(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzi(zzbva zzbvaVar, zzbvj zzbvjVar) throws RemoteException {
        throw null;
    }
}
