package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbth extends zzayt implements zzbtj {
    zzbth(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zze(Intent intent) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, intent);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeStringArray(strArr);
        zza.writeIntArray(iArr);
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(4, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzh() throws RemoteException {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzaVar);
        zzdb(6, zza);
    }
}
