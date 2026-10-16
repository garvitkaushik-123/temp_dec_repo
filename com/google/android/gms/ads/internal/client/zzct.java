package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzct extends zzayt implements zzcv {
    zzct(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzb() throws RemoteException {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzc() throws RemoteException {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzd(zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zze() throws RemoteException {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzf() throws RemoteException {
        zzdb(2, zza());
    }
}
