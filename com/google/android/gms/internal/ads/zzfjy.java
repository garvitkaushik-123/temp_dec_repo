package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfjy {
    private final Context zza;
    private final Executor zzb;
    private final zzgdz zzc;
    private final com.google.android.gms.ads.internal.util.client.zzu zzd;
    private final zzfjq zze;
    private final zzfhx zzf;

    zzfjy(Context context, Executor executor, zzgdz zzgdzVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzfjq zzfjqVar, zzfhx zzfhxVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzgdzVar;
        this.zzd = zzuVar;
        this.zze = zzfjqVar;
        this.zzf = zzfhxVar;
    }

    public final void zzd(final String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar, zzfhu zzfhuVar, zzcyi zzcyiVar) {
        ListenableFuture zzb;
        zzfhj zzfhjVar = null;
        if (zzfhx.zza() && ((Boolean) zzbex.zzd.zze()).booleanValue()) {
            zzfhjVar = zzfhi.zza(this.zza, 14);
            zzfhjVar.zzi();
        }
        if (zzvVar != null) {
            zzb = new zzfjp(zzvVar.zzb(), this.zzd, this.zzc, this.zze).zzd(str);
        } else {
            zzb = this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfjw
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    com.google.android.gms.ads.internal.util.client.zzt zza;
                    zza = zzfjy.this.zzd.zza(str);
                    return zza;
                }
            });
        }
        zzgdn.zzr(zzb, new zzfjx(this, zzfhjVar, zzfhuVar, zzcyiVar), this.zzb);
    }

    public final void zze(List list, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzd((String) it.next(), zzvVar, null, null);
        }
    }
}
