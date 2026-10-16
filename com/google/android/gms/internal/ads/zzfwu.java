package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfwu implements Iterator {
    final Iterator zza;
    Collection zzb;
    final /* synthetic */ zzfwv zzc;

    zzfwu(zzfwv zzfwvVar) {
        Objects.requireNonNull(zzfwvVar);
        this.zzc = zzfwvVar;
        this.zza = zzfwvVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        return this.zzc.zza(entry);
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        zzfvp.zzm(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzfxi zzfxiVar = this.zzc.zzb;
        i = zzfxiVar.zzb;
        zzfxiVar.zzb = i - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
