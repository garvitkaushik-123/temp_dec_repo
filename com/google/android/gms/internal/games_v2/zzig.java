package com.google.android.gms.internal.games_v2;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
final class zzig extends zzhl {
    static final zzig zzc;
    final transient zzhd zzd;

    static {
        int i = zzhd.zzd;
        zzc = new zzig(zzhz.zza, zzhr.zza);
    }

    zzig(zzhd zzhdVar, Comparator comparator) {
        super(comparator);
        this.zzd = zzhdVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        zzhd zzhdVar = this.zzd;
        int zzs = zzs(obj, true);
        if (zzs == zzhdVar.size()) {
            return null;
        }
        return zzhdVar.get(zzs);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzd, obj, this.zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzhq) {
            collection = ((zzhq) collection).zza();
        }
        Comparator comparator = ((zzhl) this).zza;
        if (!zzik.zza(comparator, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzim listIterator = this.zzd.listIterator(0);
        Iterator it = collection.iterator();
        if (!listIterator.hasNext()) {
            return false;
        }
        Object next = it.next();
        E next2 = listIterator.next();
        while (true) {
            try {
                int compare = comparator.compare(next2, next);
                if (compare >= 0) {
                    if (compare != 0) {
                        break;
                    }
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else {
                    if (!listIterator.hasNext()) {
                        return false;
                    }
                    next2 = listIterator.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        zzhd zzhdVar = this.zzd;
        if (zzhdVar.size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!zzik.zza(this.zza, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            zzim listIterator = zzhdVar.listIterator(0);
            while (listIterator.hasNext()) {
                E next = listIterator.next();
                Object next2 = it.next();
                if (next2 == null || ((zzhl) this).zza.compare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object floor(Object obj) {
        int zzr = zzr(obj, true) - 1;
        if (zzr == -1) {
            return null;
        }
        return this.zzd.get(zzr);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object higher(Object obj) {
        zzhd zzhdVar = this.zzd;
        int zzs = zzs(obj, false);
        if (zzs == zzhdVar.size()) {
            return null;
        }
        return zzhdVar.get(zzs);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(r0.size() - 1);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object lower(Object obj) {
        int zzr = zzr(obj, false) - 1;
        if (zzr == -1) {
            return null;
        }
        return this.zzd.get(zzr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy
    /* renamed from: zza */
    public final zzil iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    final Object[] zzb() {
        return this.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    final int zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    final int zzd() {
        return this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    final int zze(Object[] objArr, int i) {
        return this.zzd.zze(objArr, 0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    final zzhl zzm(Object obj, boolean z) {
        return zzt(0, zzr(obj, z));
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    final zzhl zzn(Object obj, boolean z, Object obj2, boolean z2) {
        return zzo(obj, z).zzm(obj2, z2);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    final zzhl zzo(Object obj, boolean z) {
        return zzt(zzs(obj, z), this.zzd.size());
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    final zzhl zzp() {
        Comparator reverseOrder = Collections.reverseOrder(this.zza);
        return isEmpty() ? zzk(reverseOrder) : new zzig(this.zzd.zzf(), reverseOrder);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public final zzil descendingIterator() {
        return this.zzd.zzf().listIterator(0);
    }

    final zzig zzt(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzd.size()) {
                return this;
            }
            i = 0;
        }
        if (i >= i2) {
            return zzk(this.zza);
        }
        zzhd zzhdVar = this.zzd;
        return new zzig(zzhdVar.subList(i, i2), this.zza);
    }

    final int zzr(Object obj, boolean z) {
        obj.getClass();
        int binarySearch = Collections.binarySearch(this.zzd, obj, ((zzhl) this).zza);
        return binarySearch >= 0 ? z ? binarySearch + 1 : binarySearch : ~binarySearch;
    }

    final int zzs(Object obj, boolean z) {
        obj.getClass();
        int binarySearch = Collections.binarySearch(this.zzd, obj, ((zzhl) this).zza);
        return binarySearch >= 0 ? z ? binarySearch : binarySearch + 1 : ~binarySearch;
    }
}
