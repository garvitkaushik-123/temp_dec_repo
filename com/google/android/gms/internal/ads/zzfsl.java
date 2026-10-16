package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfsl extends zzayt implements zzfsn {
    zzfsl(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    @Override // com.google.android.gms.internal.ads.zzfsn
    public final void zze(Bundle bundle, zzfsp zzfspVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, bundle);
        zzayv.zzg(zza, zzfspVar);
        zzdc(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsn
    public final void zzf(String str, Bundle bundle, zzfsp zzfspVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayv.zze(zza, bundle);
        zzayv.zzg(zza, zzfspVar);
        zzdc(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsn
    public final void zzg(Bundle bundle, zzfsp zzfspVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, bundle);
        zzayv.zzg(zza, zzfspVar);
        zzdc(3, zza);
    }
}
