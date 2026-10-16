package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgda extends zzgcn {
    private zzgcz zza;

    zzgda(zzfyl zzfylVar, boolean z, Executor executor, Callable callable) {
        super(zzfylVar, z, false);
        this.zza = new zzgcy(this, callable, executor);
        zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzgcn
    final void zzA(int i) {
        super.zzA(i);
        if (i == 1) {
            this.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    protected final void zzk() {
        zzgcz zzgczVar = this.zza;
        if (zzgczVar != null) {
            zzgczVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcn
    final void zzx(int i, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzgcn
    final void zzy() {
        zzgcz zzgczVar = this.zza;
        if (zzgczVar != null) {
            zzgczVar.zzf();
        }
    }
}
