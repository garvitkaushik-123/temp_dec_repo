package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxp implements Callable {
    private final zzawx zza;
    private final zzast zzb;

    public zzaxp(zzawx zzawxVar, zzast zzastVar) {
        this.zza = zzawxVar;
        this.zzb = zzastVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzawx zzawxVar = this.zza;
        if (zzawxVar.zzk() != null) {
            zzawxVar.zzk().get();
        }
        zzatq zzc = zzawxVar.zzc();
        if (zzc == null) {
            return null;
        }
        try {
            zzast zzastVar = this.zzb;
            synchronized (zzastVar) {
                zzastVar.zzaY(zzc.zzaV(), zzgyr.zza());
            }
            return null;
        } catch (zzgzw | NullPointerException unused) {
            return null;
        }
    }
}
