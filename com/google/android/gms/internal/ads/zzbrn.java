package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbrn extends zzayt implements zzbrp {
    zzbrn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final com.google.android.gms.ads.internal.client.zzed zze() throws RemoteException {
        Parcel zzda = zzda(5, zza());
        com.google.android.gms.ads.internal.client.zzed zzb = com.google.android.gms.ads.internal.client.zzec.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final zzbse zzf() throws RemoteException {
        Parcel zzda = zzda(2, zza());
        zzbse zzbseVar = (zzbse) zzayv.zza(zzda, zzbse.CREATOR);
        zzda.recycle();
        return zzbseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final zzbse zzg() throws RemoteException {
        Parcel zzda = zzda(3, zza());
        zzbse zzbseVar = (zzbse) zzayv.zza(zzda, zzbse.CREATOR);
        zzda.recycle();
        return zzbseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbrs zzbrsVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zza.writeString(str);
        zzayv.zze(zza, bundle);
        zzayv.zze(zza, bundle2);
        zzayv.zze(zza, zzrVar);
        zzayv.zzg(zza, zzbrsVar);
        zzdb(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbra zzbraVar, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbraVar);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(23, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbrdVar);
        zzayv.zzg(zza, zzbpwVar);
        zzayv.zze(zza, zzrVar);
        zzdb(13, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbrdVar);
        zzayv.zzg(zza, zzbpwVar);
        zzayv.zze(zza, zzrVar);
        zzdb(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrg zzbrgVar, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbrgVar);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(14, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbrjVar);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(18, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar, zzbge zzbgeVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbrjVar);
        zzayv.zzg(zza, zzbpwVar);
        zzayv.zze(zza, zzbgeVar);
        zzdb(22, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbrmVar);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(20, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zze(zza, zzmVar);
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbrmVar);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(16, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzq(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdb(19, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        Parcel zzda = zzda(24, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        Parcel zzda = zzda(15, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        Parcel zzda = zzda(17, zza);
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }
}
