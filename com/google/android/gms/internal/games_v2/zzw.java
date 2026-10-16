package com.google.android.gms.internal.games_v2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
public final class zzw extends zza implements IInterface {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.connect.IGamesConnectService");
    }

    public final void zzd(zzv zzvVar, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzvVar);
        zzc.zzc(zza, zzqVar);
        zzc(2, zza);
    }
}
