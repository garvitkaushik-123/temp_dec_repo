package com.google.android.gms.internal.ads;

import android.view.Surface;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaav implements zzacl {
    final /* synthetic */ zzaba zza;

    zzaav(zzaba zzabaVar) {
        Objects.requireNonNull(zzabaVar);
        this.zza = zzabaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zza() {
        Surface surface;
        zzaba zzabaVar = this.zza;
        surface = zzabaVar.zzs;
        if (surface != null) {
            zzabaVar.zzbk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzb() {
        zzlz zzaE;
        zzaE = this.zza.zzaE();
        if (zzaE != null) {
            zzaE.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzc() {
        Surface surface;
        zzaba zzabaVar = this.zza;
        surface = zzabaVar.zzs;
        if (surface != null) {
            zzabaVar.zzba(0, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzd(zzcd zzcdVar) {
    }
}
