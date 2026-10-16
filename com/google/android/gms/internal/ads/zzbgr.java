package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbgr extends zzayt implements zzbgt {
    zzbgr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzc() throws RemoteException {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdA(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(9, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdB(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdx(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdz(zzbgm zzbgmVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbgmVar);
        zzdb(8, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zza.writeInt(i);
        zzdb(5, zza);
    }
}
