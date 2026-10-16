package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzayw extends zzayt implements zzayy {
    zzayw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zze(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zza.writeString("GMA_SDK");
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzf() throws RemoteException {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdb(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzh(int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeIntArray(null);
        zzdb(4, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzi(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(0);
        zzdb(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzj(byte[] bArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeByteArray(bArr);
        zzdb(5, zza);
    }
}
