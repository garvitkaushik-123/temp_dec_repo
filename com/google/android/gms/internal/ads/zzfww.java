package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
class zzfww implements Iterator {
    final Iterator zza;
    Collection zzb;
    Iterator zzc;
    final /* synthetic */ zzfxi zzd;

    zzfww(zzfxi zzfxiVar) {
        Map map;
        Objects.requireNonNull(zzfxiVar);
        this.zzd = zzfxiVar;
        map = zzfxiVar.zza;
        this.zza = map.entrySet().iterator();
        this.zzb = null;
        this.zzc = zzfyy.INSTANCE;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzc.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zzc.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.zzb = collection;
            this.zzc = collection.iterator();
        }
        return this.zzc.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        this.zzc.remove();
        if (((Collection) Objects.requireNonNull(this.zzb)).isEmpty()) {
            this.zza.remove();
        }
        zzfxi zzfxiVar = this.zzd;
        i = zzfxiVar.zzb;
        zzfxiVar.zzb = i - 1;
    }
}
