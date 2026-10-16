package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbpo extends zzayt implements zzbpq {
    zzbpo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final zzbpt zzb(String str) throws RemoteException {
        zzbpt zzbprVar;
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(1, zza);
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbprVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzbprVar = queryLocalInterface instanceof zzbpt ? (zzbpt) queryLocalInterface : new zzbpr(readStrongBinder);
        }
        zzda.recycle();
        return zzbprVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final zzbrp zzc(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(3, zza);
        zzbrp zzb = zzbro.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final boolean zzd(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(4, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final boolean zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(2, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }
}
