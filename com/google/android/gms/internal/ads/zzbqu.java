package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbqu extends zzbpv {
    private final Adapter zza;
    private final zzbwn zzb;

    zzbqu(Adapter adapter, zzbwn zzbwnVar) {
        this.zza = adapter;
        this.zzb = zzbwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zze() throws RemoteException {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzf() throws RemoteException {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzg(int i) throws RemoteException {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzg(ObjectWrapper.wrap(this.zza), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzi(int i, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzj(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzm() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzn() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzo() throws RemoteException {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzp() throws RemoteException {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzq(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzr(zzbhj zzbhjVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzs(zzbwo zzbwoVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzt(zzbws zzbwsVar) throws RemoteException {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzm(ObjectWrapper.wrap(this.zza), new zzbwo(zzbwsVar.zzf(), zzbwsVar.zze()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzu() throws RemoteException {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzv() throws RemoteException {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzo(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzw() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzx() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzy() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzz() throws RemoteException {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzp(ObjectWrapper.wrap(this.zza));
        }
    }
}
