package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzffb implements zzgdj {
    final /* synthetic */ zzffe zza;
    final /* synthetic */ zzfff zzb;

    zzffb(zzfff zzfffVar, zzffe zzffeVar) {
        this.zza = zzffeVar;
        Objects.requireNonNull(zzfffVar);
        this.zzb = zzfffVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfff zzfffVar = this.zzb;
        synchronized (zzfffVar) {
            zzfffVar.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ArrayDeque arrayDeque;
        int i;
        zzfff zzfffVar = this.zzb;
        synchronized (zzfffVar) {
            zzfffVar.zze = null;
            arrayDeque = zzfffVar.zzd;
            arrayDeque.addFirst(this.zza);
            i = zzfffVar.zzf;
            if (i == 1) {
                zzfffVar.zzh();
            }
        }
    }
}
