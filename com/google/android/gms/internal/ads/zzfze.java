package com.google.android.gms.internal.ads;

import java.util.ListIterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfze extends zzgav {
    final /* synthetic */ zzfzf zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfze(zzfzf zzfzfVar, ListIterator listIterator) {
        super(listIterator);
        Objects.requireNonNull(zzfzfVar);
        this.zza = zzfzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
