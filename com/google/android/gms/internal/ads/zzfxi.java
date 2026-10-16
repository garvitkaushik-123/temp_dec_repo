package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzfxi extends zzfxl implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    protected zzfxi(Map map) {
        zzfvp.zze(map.isEmpty());
        this.zza = map;
    }

    static /* bridge */ /* synthetic */ void zzo(zzfxi zzfxiVar, Object obj) {
        Object obj2;
        try {
            obj2 = zzfxiVar.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzfxiVar.zzb -= size;
        }
    }

    abstract Collection zza();

    Collection zzb(Collection collection) {
        throw null;
    }

    Collection zzc(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    public final int zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxl
    final Collection zzf() {
        return new zzfxk(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfxl
    final Iterator zzg() {
        return new zzfws(this);
    }

    final List zzh(Object obj, List list, zzfxf zzfxfVar) {
        return list instanceof RandomAccess ? new zzfxb(this, obj, list, zzfxfVar) : new zzfxh(this, obj, list, zzfxfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfxl
    Map zzj() {
        throw null;
    }

    final Map zzk() {
        Map map = this.zza;
        return map instanceof NavigableMap ? new zzfwz(this, (NavigableMap) map) : map instanceof SortedMap ? new zzfxc(this, (SortedMap) map) : new zzfwv(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfxl
    Set zzl() {
        throw null;
    }

    final Set zzm() {
        Map map = this.zza;
        return map instanceof NavigableMap ? new zzfxa(this, (NavigableMap) map) : map instanceof SortedMap ? new zzfxd(this, (SortedMap) map) : new zzfwy(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    public final void zzp() {
        Map map = this.zza;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfxl, com.google.android.gms.internal.ads.zzfzo
    public final boolean zzq(Object obj, Object obj2) {
        Map map = this.zza;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection zza = zza();
        if (!zza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        map.put(obj, zza);
        return true;
    }
}
