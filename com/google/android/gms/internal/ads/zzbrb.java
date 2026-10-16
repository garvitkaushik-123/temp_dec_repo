package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbrb extends zzayt implements zzbrd {
    zzbrb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zzh(zzbpz zzbpzVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbpzVar);
        zzdb(4, zza);
    }
}
