package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfhs implements zzgdj {
    final /* synthetic */ zzfhu zza;
    final /* synthetic */ zzfhj zzb;

    zzfhs(zzfhu zzfhuVar, zzfhj zzfhjVar) {
        this.zza = zzfhuVar;
        this.zzb = zzfhjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhj zzfhjVar = this.zzb;
        zzfhjVar.zzh(th);
        zzfhjVar.zzg(false);
        this.zza.zza(zzfhjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
    }
}
