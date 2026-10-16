package com.google.android.gms.internal.ads;

import android.view.Surface;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaap {
    final /* synthetic */ zzaar zza;
    private zzz zzb;

    /* synthetic */ zzaap(zzaar zzaarVar, zzaaq zzaaqVar) {
        Objects.requireNonNull(zzaarVar);
        this.zza = zzaarVar;
    }

    public final void zza(final zzcd zzcdVar) {
        Executor executor;
        zzx zzxVar = new zzx();
        zzxVar.zzam(zzcdVar.zzb);
        zzxVar.zzQ(zzcdVar.zzc);
        zzxVar.zzah("video/raw");
        this.zzb = zzxVar.zzan();
        executor = this.zza.zzh;
        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaao
            @Override // java.lang.Runnable
            public final void run() {
                zzacl zzaclVar;
                zzaclVar = zzaap.this.zza.zzg;
                zzaclVar.zzd(zzcdVar);
            }
        });
    }

    public final void zzb(long j, long j2, boolean z) {
        zzabp zzabpVar;
        Queue queue;
        Surface surface;
        Executor executor;
        if (z) {
            zzaar zzaarVar = this.zza;
            surface = zzaarVar.zzd;
            if (surface != null) {
                executor = zzaarVar.zzh;
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaam
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzacl zzaclVar;
                        zzaclVar = zzaap.this.zza.zzg;
                        zzaclVar.zza();
                    }
                });
            }
        }
        zzz zzzVar = this.zzb;
        if (zzzVar == null) {
            zzzVar = new zzx().zzan();
        }
        zzz zzzVar2 = zzzVar;
        zzaar zzaarVar2 = this.zza;
        zzabpVar = zzaarVar2.zzi;
        zzabpVar.zzcT(j2, j, zzzVar2, null);
        queue = zzaarVar2.zzc;
        ((zzacm) queue.remove()).zza(j);
    }
}
