package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes4.dex */
public final class zzad extends com.google.android.gms.internal.common.zza implements zzaf {
    zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final com.google.android.gms.common.zzu zze(com.google.android.gms.common.zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzsVar);
        Parcel zzB = zzB(6, zza);
        com.google.android.gms.common.zzu zzuVar = (com.google.android.gms.common.zzu) com.google.android.gms.internal.common.zzc.zza(zzB, com.google.android.gms.common.zzu.CREATOR);
        zzB.recycle();
        return zzuVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final com.google.android.gms.common.zzu zzf(com.google.android.gms.common.zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzsVar);
        Parcel zzB = zzB(8, zza);
        com.google.android.gms.common.zzu zzuVar = (com.google.android.gms.common.zzu) com.google.android.gms.internal.common.zzc.zza(zzB, com.google.android.gms.common.zzu.CREATOR);
        zzB.recycle();
        return zzuVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzg() throws RemoteException {
        Parcel zzB = zzB(9, zza());
        boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzh(com.google.android.gms.common.zzw zzwVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzwVar);
        com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
        Parcel zzB = zzB(5, zza);
        boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzi() throws RemoteException {
        Parcel zzB = zzB(7, zza());
        boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }
}
