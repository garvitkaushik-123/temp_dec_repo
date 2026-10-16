package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbqb extends zzayt implements IInterface {
    zzbqb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    public final double zze() throws RemoteException {
        Parcel zzda = zzda(7, zza());
        double readDouble = zzda.readDouble();
        zzda.recycle();
        return readDouble;
    }

    public final Bundle zzf() throws RemoteException {
        Parcel zzda = zzda(15, zza());
        Bundle bundle = (Bundle) zzayv.zza(zzda, Bundle.CREATOR);
        zzda.recycle();
        return bundle;
    }

    public final com.google.android.gms.ads.internal.client.zzed zzg() throws RemoteException {
        Parcel zzda = zzda(17, zza());
        com.google.android.gms.ads.internal.client.zzed zzb = com.google.android.gms.ads.internal.client.zzec.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    public final zzbgi zzh() throws RemoteException {
        Parcel zzda = zzda(19, zza());
        zzbgi zzj = zzbgh.zzj(zzda.readStrongBinder());
        zzda.recycle();
        return zzj;
    }

    public final zzbgp zzi() throws RemoteException {
        Parcel zzda = zzda(5, zza());
        zzbgp zzh = zzbgo.zzh(zzda.readStrongBinder());
        zzda.recycle();
        return zzh;
    }

    public final IObjectWrapper zzj() throws RemoteException {
        Parcel zzda = zzda(18, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzk() throws RemoteException {
        Parcel zzda = zzda(20, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzl() throws RemoteException {
        Parcel zzda = zzda(21, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    public final String zzm() throws RemoteException {
        Parcel zzda = zzda(4, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    public final String zzn() throws RemoteException {
        Parcel zzda = zzda(6, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    public final String zzo() throws RemoteException {
        Parcel zzda = zzda(2, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    public final String zzp() throws RemoteException {
        Parcel zzda = zzda(9, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    public final String zzq() throws RemoteException {
        Parcel zzda = zzda(8, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    public final List zzr() throws RemoteException {
        Parcel zzda = zzda(3, zza());
        ArrayList zzb = zzayv.zzb(zzda);
        zzda.recycle();
        return zzb;
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(11, zza);
    }

    public final void zzt() throws RemoteException {
        zzdb(10, zza());
    }

    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(12, zza);
    }

    public final void zzv(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, iObjectWrapper2);
        zzayv.zzg(zza, iObjectWrapper3);
        zzdb(22, zza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(16, zza);
    }

    public final boolean zzx() throws RemoteException {
        Parcel zzda = zzda(14, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    public final boolean zzy() throws RemoteException {
        Parcel zzda = zzda(13, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }
}
