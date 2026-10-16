package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzdr extends zzayt implements zzdt {
    zzdr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final void zze(zzt zztVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zztVar);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final boolean zzf() throws RemoteException {
        Parcel zzda = zzda(2, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }
}
