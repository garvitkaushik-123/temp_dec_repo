package com.instagram.common.viewpoint.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class BI<K, V> extends AbstractC2508qf<Map.Entry<K, V>> {
    public abstract Map<K, V> A00();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC2508qf, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c) {
        try {
            return super.removeAll((Collection) AbstractC2159ki.A04(c));
        } catch (UnsupportedOperationException unused) {
            return AbstractC2512qj.A0B(this, c.iterator());
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC2508qf, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> c) {
        try {
            return super.retainAll((Collection) AbstractC2159ki.A04(c));
        } catch (UnsupportedOperationException unused) {
            HashSet A06 = AbstractC2512qj.A06(c.size());
            for (Object obj : c) {
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    A06.add(((Map.Entry) obj).getKey());
                }
            }
            return A00().keySet().retainAll(A06);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BI != com.google.common.collect.Maps$EntrySet<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        A00().clear();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BI != com.google.common.collect.Maps$EntrySet<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return A00().isEmpty();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BI != com.google.common.collect.Maps$EntrySet<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return A00().size();
    }
}
