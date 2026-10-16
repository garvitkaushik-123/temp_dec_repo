package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfwx implements Iterator {
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzfwy zzc;

    zzfwx(zzfwy zzfwyVar, Iterator it) {
        this.zzb = it;
        Objects.requireNonNull(zzfwyVar);
        this.zzc = zzfwyVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        zzfvp.zzm(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzfxi zzfxiVar = this.zzc.zza;
        i = zzfxiVar.zzb;
        zzfxiVar.zzb = i - collection.size();
        collection.clear();
        this.zza = null;
    }
}
