package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdnb extends zzbhd {
    private final String zza;
    private final zzdio zzb;
    private final zzdit zzc;

    public zzdnb(String str, zzdio zzdioVar, zzdit zzditVar) {
        this.zza = str;
        this.zzb = zzdioVar;
        this.zzc = zzditVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final double zzb() throws RemoteException {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final Bundle zzc() throws RemoteException {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final com.google.android.gms.ads.internal.client.zzed zzd() throws RemoteException {
        return this.zzc.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final zzbgi zze() throws RemoteException {
        return this.zzc.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final zzbgp zzf() throws RemoteException {
        return this.zzc.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final IObjectWrapper zzg() throws RemoteException {
        return this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final IObjectWrapper zzh() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzi() throws RemoteException {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzj() throws RemoteException {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzk() throws RemoteException {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzl() throws RemoteException {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzm() throws RemoteException {
        return this.zzc.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzn() throws RemoteException {
        return this.zzc.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final List zzo() throws RemoteException {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final void zzp() throws RemoteException {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final void zzq(Bundle bundle) throws RemoteException {
        this.zzb.zzH(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final void zzr(Bundle bundle) throws RemoteException {
        this.zzb.zzN(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final boolean zzs(Bundle bundle) throws RemoteException {
        return this.zzb.zzaa(bundle);
    }
}
