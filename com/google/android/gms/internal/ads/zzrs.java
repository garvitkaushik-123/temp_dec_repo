package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzrs implements zzql {
    final /* synthetic */ zzru zza;

    /* synthetic */ zzrs(zzru zzruVar, zzrt zzrtVar) {
        Objects.requireNonNull(zzruVar);
        this.zza = zzruVar;
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zza(Exception exc) {
        zzqg zzqgVar;
        zzea.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        zzqgVar = this.zza.zzc;
        zzqgVar.zzp(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zzb() {
        zzlz zzaE;
        zzaE = this.zza.zzaE();
        if (zzaE != null) {
            zzaE.zza();
        }
    }
}
