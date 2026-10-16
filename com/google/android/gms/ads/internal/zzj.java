package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfoi;
import com.google.android.gms.internal.ads.zzfpj;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzj implements zzfpj {
    final /* synthetic */ zzk zza;

    zzj(zzk zzkVar) {
        Objects.requireNonNull(zzkVar);
        this.zza = zzkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpj
    public final void zza(int i, long j) {
        zzfoi zzfoiVar;
        zzfoiVar = this.zza.zzj;
        zzfoiVar.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfpj
    public final void zzb(int i, long j, String str) {
        zzfoi zzfoiVar;
        zzfoiVar = this.zza.zzj;
        zzfoiVar.zze(i, System.currentTimeMillis() - j, str);
    }
}
