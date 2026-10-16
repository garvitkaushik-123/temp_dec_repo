package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbdx extends zzayt implements zzbdz {
    zzbdx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zze(zzbdw zzbdwVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbdwVar);
        zzdb(1, zza);
    }
}
