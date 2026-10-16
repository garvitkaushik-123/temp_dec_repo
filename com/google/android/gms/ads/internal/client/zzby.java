package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbpq;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzby extends zzayt implements IInterface {
    zzby(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbpq zzbpqVar, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzrVar);
        zza.writeString(str);
        zzayv.zzg(zza, zzbpqVar);
        zza.writeInt(ModuleDescriptor.MODULE_VERSION);
        zza.writeInt(i2);
        Parcel zzda = zzda(2, zza);
        IBinder readStrongBinder = zzda.readStrongBinder();
        zzda.recycle();
        return readStrongBinder;
    }
}
