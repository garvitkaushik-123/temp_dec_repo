package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzavj implements zzfpj {
    final /* synthetic */ zzfoi zza;

    zzavj(zzfoi zzfoiVar) {
        this.zza = zzfoiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpj
    public final void zza(int i, long j) {
        this.zza.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfpj
    public final void zzb(int i, long j, String str) {
        this.zza.zze(i, System.currentTimeMillis() - j, str);
    }
}
