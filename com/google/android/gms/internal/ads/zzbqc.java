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
public final class zzbqc extends zzayt implements IInterface {
    zzbqc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public final Bundle zze() throws RemoteException {
        Parcel zzda = zzda(13, zza());
        Bundle bundle = (Bundle) zzayv.zza(zzda, Bundle.CREATOR);
        zzda.recycle();
        return bundle;
    }

    public final com.google.android.gms.ads.internal.client.zzed zzf() throws RemoteException {
        Parcel zzda = zzda(16, zza());
        com.google.android.gms.ads.internal.client.zzed zzb = com.google.android.gms.ads.internal.client.zzec.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    public final zzbgi zzg() throws RemoteException {
        Parcel zzda = zzda(19, zza());
        zzbgi zzj = zzbgh.zzj(zzda.readStrongBinder());
        zzda.recycle();
        return zzj;
    }

    public final zzbgp zzh() throws RemoteException {
        Parcel zzda = zzda(5, zza());
        zzbgp zzh = zzbgo.zzh(zzda.readStrongBinder());
        zzda.recycle();
        return zzh;
    }

    public final IObjectWrapper zzi() throws RemoteException {
        Parcel zzda = zzda(15, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzj() throws RemoteException {
        Parcel zzda = zzda(20, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzk() throws RemoteException {
        Parcel zzda = zzda(21, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    public final String zzl() throws RemoteException {
        Parcel zzda = zzda(7, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
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

    public final List zzp() throws RemoteException {
        Parcel zzda = zzda(3, zza());
        ArrayList zzb = zzayv.zzb(zzda);
        zzda.recycle();
        return zzb;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(9, zza);
    }

    public final void zzr() throws RemoteException {
        zzdb(8, zza());
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(10, zza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, iObjectWrapper2);
        zzayv.zzg(zza, iObjectWrapper3);
        zzdb(22, zza);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(14, zza);
    }

    public final boolean zzv() throws RemoteException {
        Parcel zzda = zzda(12, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    public final boolean zzw() throws RemoteException {
        Parcel zzda = zzda(11, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }
}
