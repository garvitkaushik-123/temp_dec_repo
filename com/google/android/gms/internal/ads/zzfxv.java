package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfxv extends AbstractSet {
    final /* synthetic */ zzfxz zza;

    zzfxv(zzfxz zzfxzVar) {
        Objects.requireNonNull(zzfxzVar);
        this.zza = zzfxzVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfxz zzfxzVar = this.zza;
        Map zzl = zzfxzVar.zzl();
        return zzl != null ? zzl.keySet().iterator() : new zzfxq(zzfxzVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Object zzy;
        Object obj2;
        zzfxz zzfxzVar = this.zza;
        Map zzl = zzfxzVar.zzl();
        if (zzl != null) {
            return zzl.keySet().remove(obj);
        }
        zzy = zzfxzVar.zzy(obj);
        obj2 = zzfxz.zzd;
        return zzy != obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
