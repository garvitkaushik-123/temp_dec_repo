package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzezk implements zzfve {
    final /* synthetic */ zzezn zza;

    zzezk(zzezn zzeznVar) {
        Objects.requireNonNull(zzeznVar);
        this.zza = zzeznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfve
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzezl zzezlVar;
        zzbvq zzbvqVar = (zzbvq) obj;
        zzezl zzezlVar2 = new zzezl(zzbvqVar, new zzfev(zzbvqVar.zzj), null);
        zzezn zzeznVar = this.zza;
        zzeznVar.zzd = zzezlVar2;
        zzezlVar = zzeznVar.zzd;
        return zzezlVar;
    }
}
