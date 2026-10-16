package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcsc implements zzgdj {
    final /* synthetic */ zzcse zza;

    zzcsc(zzcse zzcseVar) {
        Objects.requireNonNull(zzcseVar);
        this.zza = zzcseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzdbk zzdbkVar;
        zzdbkVar = this.zza.zzf;
        zzdbkVar.zzn(false);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(@NullableDecl Object obj) {
        zzdbk zzdbkVar;
        zzdbkVar = this.zza.zzf;
        zzdbkVar.zzn(true);
    }
}
