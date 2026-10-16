package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbhh extends zzayt implements zzbhj {
    zzbhh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final com.google.android.gms.ads.internal.client.zzed zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final zzbgm zzf() throws RemoteException {
        zzbgm zzbgkVar;
        Parcel zzda = zzda(16, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbgkVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbgkVar = queryLocalInterface instanceof zzbgm ? (zzbgm) queryLocalInterface : new zzbgk(readStrongBinder);
        }
        zzda.recycle();
        return zzbgkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final zzbgp zzg(String str) throws RemoteException {
        zzbgp zzbgnVar;
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(2, zza);
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbgnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbgnVar = queryLocalInterface instanceof zzbgp ? (zzbgp) queryLocalInterface : new zzbgn(readStrongBinder);
        }
        zzda.recycle();
        return zzbgnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final IObjectWrapper zzh() throws RemoteException {
        Parcel zzda = zzda(9, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final String zzi() throws RemoteException {
        Parcel zzda = zzda(4, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final String zzj(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzda = zzda(1, zza);
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final List zzk() throws RemoteException {
        Parcel zzda = zzda(3, zza());
        ArrayList<String> createStringArrayList = zzda.createStringArrayList();
        zzda.recycle();
        return createStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzl() throws RemoteException {
        zzdb(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzm() throws RemoteException {
        zzdb(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzn(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdb(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzo() throws RemoteException {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(14, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzq() throws RemoteException {
        Parcel zzda = zzda(12, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        Parcel zzda = zzda(17, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        Parcel zzda = zzda(10, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzt() throws RemoteException {
        Parcel zzda = zzda(13, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }
}
