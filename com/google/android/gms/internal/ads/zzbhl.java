package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbhl extends zzayt implements zzbhn {
    zzbhl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zze(zzbhe zzbheVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbheVar);
        zzdb(1, zza);
    }
}
