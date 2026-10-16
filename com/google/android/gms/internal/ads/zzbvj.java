package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbvj extends zzayt implements IInterface {
    zzbvj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.ITrustlessTokenListener");
    }

    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbbVar);
        zzdb(2, zza);
    }

    public final void zzf(String str, zzbva zzbvaVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayv.zze(zza, zzbvaVar);
        zzdb(1, zza);
    }
}
