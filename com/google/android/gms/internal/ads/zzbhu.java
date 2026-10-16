package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbhu extends zzayt implements zzbhw {
    zzbhu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbhw
    public final void zze(zzbhj zzbhjVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbhjVar);
        zzdb(1, zza);
    }
}
