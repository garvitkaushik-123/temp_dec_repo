package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbre extends zzayt implements zzbrg {
    zzbre(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzdb(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzeVar);
        zzdb(4, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final void zzg() throws RemoteException {
        zzdb(2, zza());
    }
}
