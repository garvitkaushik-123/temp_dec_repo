package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbyy extends zzayt implements zzbza {
    zzbyy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, iObjectWrapper2);
        zza.writeString(str);
        zzayv.zzg(zza, iObjectWrapper3);
        Parcel zzda = zzda(11, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzf(IObjectWrapper iObjectWrapper, zzbze zzbzeVar, zzbyx zzbyxVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzbzeVar);
        zzayv.zzg(zza, zzbyxVar);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzg(zzbui zzbuiVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(8, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) throws RemoteException {
        throw null;
    }
}
