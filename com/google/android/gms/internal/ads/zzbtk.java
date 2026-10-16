package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbtk extends zzayt implements zzbtm {
    zzbtk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final zzbtj zze(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) throws RemoteException {
        zzbtj zzbthVar;
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbpqVar);
        zza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel zzda = zzda(1, zza);
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbthVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
            zzbthVar = queryLocalInterface instanceof zzbtj ? (zzbtj) queryLocalInterface : new zzbth(readStrongBinder);
        }
        zzda.recycle();
        return zzbthVar;
    }
}
