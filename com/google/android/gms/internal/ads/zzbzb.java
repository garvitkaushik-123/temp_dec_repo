package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbzb extends zzayt implements zzbzd {
    zzbzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbzd
    public final zzbza zze(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) throws RemoteException {
        zzbza zzbyyVar;
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbpqVar);
        zza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel zzda = zzda(2, zza);
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbyyVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            zzbyyVar = queryLocalInterface instanceof zzbza ? (zzbza) queryLocalInterface : new zzbyy(readStrongBinder);
        }
        zzda.recycle();
        return zzbyyVar;
    }
}
