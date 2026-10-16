package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbi extends zzayt implements zzbk {
    zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzc() throws RemoteException {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzd() throws RemoteException {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zze(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzf(zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(8, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzg() throws RemoteException {
        zzdb(7, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzh() throws RemoteException {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzi() throws RemoteException {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzj() throws RemoteException {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzk() throws RemoteException {
        zzdb(9, zza());
    }
}
