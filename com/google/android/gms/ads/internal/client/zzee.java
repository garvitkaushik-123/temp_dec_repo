package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzee extends zzayt implements zzeg {
    zzee(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zze() throws RemoteException {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzf(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayv.zza;
        zza.writeInt(z ? 1 : 0);
        zzdb(5, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzg() throws RemoteException {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzh() throws RemoteException {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzi() throws RemoteException {
        zzdb(1, zza());
    }
}
