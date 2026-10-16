package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzehq extends zzbrl {
    private final zzedp zza;

    /* synthetic */ zzehq(zzehs zzehsVar, zzedp zzedpVar, zzehr zzehrVar) {
        Objects.requireNonNull(zzehsVar);
        this.zza = zzedpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zze(String str) throws RemoteException {
        ((zzefd) this.zza.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzefd) this.zza.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzg() throws RemoteException {
        ((zzefd) this.zza.zzc).zzo();
    }
}
