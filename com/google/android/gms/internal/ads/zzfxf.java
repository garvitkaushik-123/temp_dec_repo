package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
class zzfxf extends AbstractCollection {
    final Object zza;
    Collection zzb;
    final zzfxf zzc;
    final Collection zzd;
    final /* synthetic */ zzfxi zze;

    zzfxf(zzfxi zzfxiVar, Object obj, Collection collection, zzfxf zzfxfVar) {
        Objects.requireNonNull(zzfxiVar);
        this.zze = zzfxiVar;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzfxfVar;
        this.zzd = zzfxfVar == null ? null : zzfxfVar.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        int i;
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (add) {
            zzfxi zzfxiVar = this.zze;
            i = zzfxiVar.zzb;
            zzfxiVar.zzb = i + 1;
            if (isEmpty) {
                zza();
                return true;
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzfxi zzfxiVar = this.zze;
        i = zzfxiVar.zzb;
        zzfxiVar.zzb = i + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int i;
        int size = size();
        if (size == 0) {
            return;
        }
        this.zzb.clear();
        zzfxi zzfxiVar = this.zze;
        i = zzfxiVar.zzb;
        zzfxiVar.zzb = i - size;
        zzc();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzb();
        return new zzfxe(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        int i;
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzfxi zzfxiVar = this.zze;
            i = zzfxiVar.zzb;
            zzfxiVar.zzb = i - 1;
            zzc();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            int size2 = this.zzb.size();
            zzfxi zzfxiVar = this.zze;
            int i2 = size2 - size;
            i = zzfxiVar.zzb;
            zzfxiVar.zzb = i + i2;
            zzc();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        zzb();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    final void zza() {
        Map map;
        zzfxf zzfxfVar = this.zzc;
        if (zzfxfVar != null) {
            zzfxfVar.zza();
            return;
        }
        zzfxi zzfxiVar = this.zze;
        Object obj = this.zza;
        map = zzfxiVar.zza;
        map.put(obj, this.zzb);
    }

    final void zzb() {
        Map map;
        zzfxf zzfxfVar = this.zzc;
        if (zzfxfVar != null) {
            zzfxfVar.zzb();
            if (zzfxfVar.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
            return;
        }
        if (this.zzb.isEmpty()) {
            zzfxi zzfxiVar = this.zze;
            Object obj = this.zza;
            map = zzfxiVar.zza;
            Collection collection = (Collection) map.get(obj);
            if (collection != null) {
                this.zzb = collection;
            }
        }
    }

    final void zzc() {
        Map map;
        zzfxf zzfxfVar = this.zzc;
        if (zzfxfVar != null) {
            zzfxfVar.zzc();
        } else if (this.zzb.isEmpty()) {
            zzfxi zzfxiVar = this.zze;
            Object obj = this.zza;
            map = zzfxiVar.zza;
            map.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i;
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            int size2 = this.zzb.size();
            zzfxi zzfxiVar = this.zze;
            int i2 = size2 - size;
            i = zzfxiVar.zzb;
            zzfxiVar.zzb = i + i2;
            zzc();
        }
        return retainAll;
    }
}
