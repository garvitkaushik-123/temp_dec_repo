package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbgk extends zzayt implements zzbgm {
    zzbgk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zze() throws RemoteException {
        Parcel zzda = zzda(2, zza());
        float readFloat = zzda.readFloat();
        zzda.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zzf() throws RemoteException {
        Parcel zzda = zzda(6, zza());
        float readFloat = zzda.readFloat();
        zzda.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zzg() throws RemoteException {
        Parcel zzda = zzda(5, zza());
        float readFloat = zzda.readFloat();
        zzda.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final com.google.android.gms.ads.internal.client.zzed zzh() throws RemoteException {
        Parcel zzda = zzda(7, zza());
        com.google.android.gms.ads.internal.client.zzed zzb = com.google.android.gms.ads.internal.client.zzec.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final IObjectWrapper zzi() throws RemoteException {
        Parcel zzda = zzda(4, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final boolean zzk() throws RemoteException {
        Parcel zzda = zzda(10, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final boolean zzl() throws RemoteException {
        Parcel zzda = zzda(8, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzm(zzbhx zzbhxVar) throws RemoteException {
        throw null;
    }
}
