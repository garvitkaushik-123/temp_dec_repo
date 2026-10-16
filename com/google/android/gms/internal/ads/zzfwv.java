package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
class zzfwv extends zzfzm {
    final transient Map zza;
    final /* synthetic */ zzfxi zzb;

    zzfwv(zzfxi zzfxiVar, Map map) {
        Objects.requireNonNull(zzfxiVar);
        this.zzb = zzfxiVar;
        this.zza = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Map map;
        zzfxi zzfxiVar = this.zzb;
        Map map2 = this.zza;
        map = zzfxiVar.zza;
        if (map2 == map) {
            zzfxiVar.zzp();
        } else {
            zzfza.zzb(new zzfwu(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.zza;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) zzfzn.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzc(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzfzm, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        return this.zzb.zzt();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        int i;
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        zzfxi zzfxiVar = this.zzb;
        Collection zza = zzfxiVar.zza();
        zza.addAll(collection);
        i = zzfxiVar.zzb;
        zzfxiVar.zzb = i - collection.size();
        collection.clear();
        return zza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.zza.toString();
    }

    final Map.Entry zza(Map.Entry entry) {
        Object key = entry.getKey();
        return new zzfym(key, this.zzb.zzc(key, (Collection) entry.getValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzfzm
    protected final Set zzb() {
        return new zzfwt(this);
    }
}
