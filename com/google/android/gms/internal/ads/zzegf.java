package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzegf extends zzbri {
    final /* synthetic */ zzegh zza;
    private final zzedp zzb;

    /* synthetic */ zzegf(zzegh zzeghVar, zzedp zzedpVar, zzegg zzeggVar) {
        Objects.requireNonNull(zzeghVar);
        this.zza = zzeghVar;
        this.zzb = zzedpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final void zze(String str) throws RemoteException {
        ((zzefd) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzefd) this.zzb.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final void zzg(zzbqf zzbqfVar) throws RemoteException {
        this.zza.zzc = zzbqfVar;
        ((zzefd) this.zzb.zzc).zzo();
    }
}
