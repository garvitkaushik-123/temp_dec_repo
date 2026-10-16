package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.internal.ads.zzbpq;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzcz extends zzayt implements zzdb {
    zzcz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final float zze() throws RemoteException {
        Parcel zzda = zzda(7, zza());
        float readFloat = zzda.readFloat();
        zzda.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final String zzf() throws RemoteException {
        Parcel zzda = zzda(9, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzg() throws RemoteException {
        Parcel zzda = zzda(13, zza());
        ArrayList createTypedArrayList = zzda.createTypedArrayList(zzbmd.CREATOR);
        zzda.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzh(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdb(10, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzi() throws RemoteException {
        zzdb(15, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzj(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayv.zza;
        zza.writeInt(z ? 1 : 0);
        zzdb(17, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzk() throws RemoteException {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzl(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(null);
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(6, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzm(zzdn zzdnVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzdnVar);
        zzdb(16, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zza.writeString(str);
        zzdb(5, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzo(zzbpq zzbpqVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbpqVar);
        zzdb(11, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzp(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayv.zza;
        zza.writeInt(z ? 1 : 0);
        zzdb(4, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzq(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzr(String str) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzs(zzbmk zzbmkVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbmkVar);
        zzdb(12, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzt(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdb(18, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzu(zzfx zzfxVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzfxVar);
        zzdb(14, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final boolean zzv() throws RemoteException {
        Parcel zzda = zzda(8, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }
}
