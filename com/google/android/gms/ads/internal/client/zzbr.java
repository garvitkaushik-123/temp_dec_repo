package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbia;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzbmp;
import com.google.android.gms.internal.ads.zzbmy;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbr extends zzayt implements zzbt {
    zzbr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final zzbq zze() throws RemoteException {
        zzbq zzboVar;
        Parcel zzda = zzda(1, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzboVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            zzboVar = queryLocalInterface instanceof zzbq ? (zzbq) queryLocalInterface : new zzbo(readStrongBinder);
        }
        zzda.recycle();
        return zzboVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzf(zzbhn zzbhnVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzg(zzbhq zzbhqVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzh(String str, zzbhw zzbhwVar, zzbht zzbhtVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayv.zzg(zza, zzbhwVar);
        zzayv.zzg(zza, zzbhtVar);
        zzdb(5, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzi(zzbmy zzbmyVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzj(zzbia zzbiaVar, zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbiaVar);
        zzayv.zze(zza, zzrVar);
        zzdb(8, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzk(zzbid zzbidVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbidVar);
        zzdb(10, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzl(zzbk zzbkVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzbkVar);
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, adManagerAdViewOptions);
        zzdb(15, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzn(zzbmp zzbmpVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzo(zzbge zzbgeVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zze(zza, zzbgeVar);
        zzdb(6, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzq(zzcs zzcsVar) throws RemoteException {
        throw null;
    }
}
