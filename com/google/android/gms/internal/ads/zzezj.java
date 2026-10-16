package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzezj implements zzfve {
    final /* synthetic */ zzezn zza;

    zzezj(zzezn zzeznVar) {
        Objects.requireNonNull(zzeznVar);
        this.zza = zzeznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfve
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzfet zze;
        zzezl zzezlVar;
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", (zzdyx) obj);
        com.google.android.gms.ads.internal.util.zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzezn zzeznVar = this.zza;
        zze = zzeznVar.zze();
        zzeznVar.zzd = new zzezl(null, zze, null);
        zzezlVar = zzeznVar.zzd;
        return zzezlVar;
    }
}
