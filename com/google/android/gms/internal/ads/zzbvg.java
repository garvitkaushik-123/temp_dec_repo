package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbvg extends zzayt implements zzbvi {
    zzbvg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbbVar);
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, parcelFileDescriptor);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvq zzbvqVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, parcelFileDescriptor);
        zzayv.zze(zza, zzbvqVar);
        zzdb(3, zza);
    }
}
