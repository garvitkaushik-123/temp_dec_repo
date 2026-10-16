package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdnd extends zzbhf {
    private final String zza;
    private final zzdio zzb;
    private final zzdit zzc;

    public zzdnd(String str, zzdio zzdioVar, zzdit zzditVar) {
        this.zza = str;
        this.zzb = zzdioVar;
        this.zzc = zzditVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final Bundle zzb() throws RemoteException {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final com.google.android.gms.ads.internal.client.zzed zzc() throws RemoteException {
        return this.zzc.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final zzbgi zzd() throws RemoteException {
        return this.zzc.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final zzbgp zze() throws RemoteException {
        return this.zzc.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final IObjectWrapper zzf() throws RemoteException {
        return this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final IObjectWrapper zzg() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzh() throws RemoteException {
        return this.zzc.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzi() throws RemoteException {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzj() throws RemoteException {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzk() throws RemoteException {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzl() throws RemoteException {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final List zzm() throws RemoteException {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final void zzn() throws RemoteException {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final void zzo(Bundle bundle) throws RemoteException {
        this.zzb.zzH(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final void zzp(Bundle bundle) throws RemoteException {
        this.zzb.zzN(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final boolean zzq(Bundle bundle) throws RemoteException {
        return this.zzb.zzaa(bundle);
    }
}
