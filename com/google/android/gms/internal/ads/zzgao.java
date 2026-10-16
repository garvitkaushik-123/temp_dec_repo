package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgao extends zzgan implements SortedSet {
    zzgao(SortedSet sortedSet, zzfvq zzfvqVar) {
        super(sortedSet, zzfvqVar);
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedSet) this.zza).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        Iterator it = this.zza.iterator();
        it.getClass();
        zzfvq zzfvqVar = this.zzb;
        zzfvqVar.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (zzfvqVar.zza(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return new zzgao(((SortedSet) this.zza).headSet(obj), this.zzb);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        SortedSet sortedSet = (SortedSet) this.zza;
        while (true) {
            zzfvq zzfvqVar = this.zzb;
            Object last = sortedSet.last();
            if (zzfvqVar.zza(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new zzgao(((SortedSet) this.zza).subSet(obj, obj2), this.zzb);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new zzgao(((SortedSet) this.zza).tailSet(obj), this.zzb);
    }
}
