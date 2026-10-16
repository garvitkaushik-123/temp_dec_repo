package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
class zzfxe implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfxf zzc;

    zzfxe(zzfxf zzfxfVar) {
        Objects.requireNonNull(zzfxfVar);
        this.zzc = zzfxfVar;
        this.zzb = zzfxfVar.zzb;
        Collection collection = zzfxfVar.zzb;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        this.zza.remove();
        zzfxf zzfxfVar = this.zzc;
        zzfxi zzfxiVar = zzfxfVar.zze;
        i = zzfxiVar.zzb;
        zzfxiVar.zzb = i - 1;
        zzfxfVar.zzc();
    }

    final void zza() {
        zzfxf zzfxfVar = this.zzc;
        zzfxfVar.zzb();
        if (zzfxfVar.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    zzfxe(zzfxf zzfxfVar, Iterator it) {
        Objects.requireNonNull(zzfxfVar);
        this.zzc = zzfxfVar;
        this.zzb = zzfxfVar.zzb;
        this.zza = it;
    }
}
