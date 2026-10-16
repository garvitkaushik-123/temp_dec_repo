package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbl extends zzayt implements zzbn {
    zzbl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb(zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzc() throws RemoteException {
        zzdb(1, zza());
    }
}
