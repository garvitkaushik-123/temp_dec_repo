package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzcf extends zzayt implements zzch {
    zzcf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zze(String str, zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayv.zze(zza, zzeVar);
        zzdb(3, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzf(String str, zzea zzeaVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayv.zzg(zza, zzeaVar);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzg(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdb(2, zza);
    }
}
