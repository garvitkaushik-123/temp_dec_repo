package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbpr extends zzayt implements zzbpt {
    zzbpr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzA(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzmVar);
        zza.writeString(str);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(28, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzB(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzC(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzmVar);
        zza.writeString(str);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(32, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzE() throws RemoteException {
        zzdb(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzF() throws RemoteException {
        zzdb(9, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzG(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayv.zza;
        zza.writeInt(z ? 1 : 0);
        zzdb(25, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(39, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzI() throws RemoteException {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(37, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzdb(30, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzL() throws RemoteException {
        zzdb(12, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final boolean zzM() throws RemoteException {
        Parcel zzda = zzda(22, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final boolean zzN() throws RemoteException {
        Parcel zzda = zzda(13, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqb zzO() throws RemoteException {
        zzbqb zzbqbVar;
        Parcel zzda = zzda(15, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbqbVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzbqbVar = queryLocalInterface instanceof zzbqb ? (zzbqb) queryLocalInterface : new zzbqb(readStrongBinder);
        }
        zzda.recycle();
        return zzbqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqc zzP() throws RemoteException {
        zzbqc zzbqcVar;
        Parcel zzda = zzda(16, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbqcVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzbqcVar = queryLocalInterface instanceof zzbqc ? (zzbqc) queryLocalInterface : new zzbqc(readStrongBinder);
        }
        zzda.recycle();
        return zzbqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final Bundle zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final com.google.android.gms.ads.internal.client.zzed zzh() throws RemoteException {
        Parcel zzda = zzda(26, zza());
        com.google.android.gms.ads.internal.client.zzed zzb = com.google.android.gms.ads.internal.client.zzec.zzb(zzda.readStrongBinder());
        zzda.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbhj zzi() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbpz zzj() throws RemoteException {
        zzbpz zzbpxVar;
        Parcel zzda = zzda(36, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbpxVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            zzbpxVar = queryLocalInterface instanceof zzbpz ? (zzbpz) queryLocalInterface : new zzbpx(readStrongBinder);
        }
        zzda.recycle();
        return zzbpxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqf zzk() throws RemoteException {
        zzbqf zzbqdVar;
        Parcel zzda = zzda(27, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzbqdVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzbqdVar = queryLocalInterface instanceof zzbqf ? (zzbqf) queryLocalInterface : new zzbqd(readStrongBinder);
        }
        zzda.recycle();
        return zzbqdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbse zzl() throws RemoteException {
        Parcel zzda = zzda(33, zza());
        zzbse zzbseVar = (zzbse) zzayv.zza(zzda, zzbse.CREATOR);
        zzda.recycle();
        return zzbseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbse zzm() throws RemoteException {
        Parcel zzda = zzda(34, zza());
        zzbse zzbseVar = (zzbse) zzayv.zza(zzda, zzbse.CREATOR);
        zzda.recycle();
        return zzbseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzda = zzda(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzda.readStrongBinder());
        zzda.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzo() throws RemoteException {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzp(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbwn zzbwnVar, String str2) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzmVar);
        zza.writeString(null);
        zzayv.zzg(zza, zzbwnVar);
        zza.writeString(str2);
        zzdb(10, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzq(IObjectWrapper iObjectWrapper, zzbmh zzbmhVar, List list) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbmhVar);
        zza.writeTypedList(list);
        zzdb(31, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzr(IObjectWrapper iObjectWrapper, zzbwn zzbwnVar, List list) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zzg(zza, zzbwnVar);
        zza.writeStringList(list);
        zzdb(23, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzs(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzmVar);
        zza.writeString(str);
        zzdb(11, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzt(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzmVar);
        zza.writeString(str);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(38, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzu(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzv(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzrVar);
        zzayv.zze(zza, zzmVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzw(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzrVar);
        zzayv.zze(zza, zzmVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(35, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzx(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzy(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzmVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zzg(zza, zzbpwVar);
        zzdb(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzz(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar, zzbge zzbgeVar, List list) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, iObjectWrapper);
        zzayv.zze(zza, zzmVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzayv.zzg(zza, zzbpwVar);
        zzayv.zze(zza, zzbgeVar);
        zza.writeStringList(list);
        zzdb(14, zza);
    }
}
