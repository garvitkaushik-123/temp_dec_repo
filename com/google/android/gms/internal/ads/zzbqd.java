package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbqd extends zzayt implements zzbqf {
    zzbqd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzA() throws RemoteException {
        Parcel zzda = zzda(18, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzB() throws RemoteException {
        Parcel zzda = zzda(17, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final double zze() throws RemoteException {
        Parcel zzda = zzda(8, zza());
        double readDouble = zzda.readDouble();
        zzda.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzf() throws RemoteException {
        Parcel zzda = zzda(23, zza());
        float readFloat = zzda.readFloat();
        zzda.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzg() throws RemoteException {
        Parcel zzda = zzda(25, zza());
        float readFloat = zzda.readFloat();
        zzda.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzh() throws RemoteException {
        Parcel zzda = zzda(24, zza());
        float readFloat = zzda.readFloat();
        zzda.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final Bundle zzi() throws RemoteException {
        Parcel zzda = zzda(16, zza());
        Bundle bundle = (Bundle) zzayv.zza(zzda, Bundle.CREATOR);
        zzda.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final com.google.android.gms.ads.internal.client.zzed zzj() throws RemoteException {
        Parcel zzda = zzda(11, zza());
        com.google.android.gms.ads.internal.client.zzed zzb = com.google.android.gms.ads.internal.client.zzec.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbgi zzk() throws RemoteException {
        Parcel zzda = zzda(12, zza());
        zzbgi zzj = zzbgh.zzj(zzda.readStrongBinder());
        zzda.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbgp zzl() throws RemoteException {
        Parcel zzda = zzda(5, zza());
        zzbgp zzh = zzbgo.zzh(zzda.readStrongBinder());
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzda = zzda(13, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzda = zzda(14, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzo() throws RemoteException {
        Parcel zzda = zzda(15, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzp() throws RemoteException {
        Parcel zzda = zzda(7, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzq() throws RemoteException {
        Parcel zzda = zzda(4, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzr() throws RemoteException {
        Parcel zzda = zzda(6, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzs() throws RemoteException {
        Parcel zzda = zzda(2, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzt() throws RemoteException {
        Parcel zzda = zzda(10, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzu() throws RemoteException {
        Parcel zzda = zzda(9, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final List zzv() throws RemoteException {
        Parcel zzda = zzda(3, zza());
        ArrayList zzb = zzayv.zzb(zzda);
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(20, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzx() throws RemoteException {
        zzdb(19, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, iObjectWrapper2);
        zzayv.zzg(zza, iObjectWrapper3);
        zzdb(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(22, zza);
    }
}
