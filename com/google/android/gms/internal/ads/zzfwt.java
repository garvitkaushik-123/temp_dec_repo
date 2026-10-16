package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfwt extends zzfzj {
    final /* synthetic */ zzfwv zza;

    zzfwt(zzfwv zzfwvVar) {
        Objects.requireNonNull(zzfwvVar);
        this.zza = zzfwvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzj, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return zzfxp.zza(this.zza.zza.entrySet(), obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzfwu(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfzj, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) Objects.requireNonNull((Map.Entry) obj);
        zzfwv zzfwvVar = this.zza;
        zzfxi.zzo(zzfwvVar.zzb, entry.getKey());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    final Map zza() {
        return this.zza;
    }
}
