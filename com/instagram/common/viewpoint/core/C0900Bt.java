package com.instagram.common.viewpoint.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* renamed from: com.facebook.ads.redexgen.X.Bt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0900Bt<K, V> extends AbstractC2458pn<K, Collection<V>> {
    public final transient Map<K, Collection<V>> A00;
    public final /* synthetic */ C2L A01;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    public C0900Bt(final C2L this$0, Map<K, Collection<V>> submap) {
        this.A01 = this$0;
        this.A00 = submap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    /* renamed from: A07, reason: merged with bridge method [inline-methods] */
    public final Collection<V> get(@CheckForNull Object key) {
        Collection<V> collection = (Collection) AbstractC2459po.A05(this.A00, key);
        if (collection == null) {
            return null;
        }
        Collection<V> collection2 = this.A01.A0F(key, collection);
        return collection2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    /* renamed from: A08, reason: merged with bridge method [inline-methods] */
    public final Collection<V> remove(@CheckForNull Object key) {
        Collection<V> remove = this.A00.remove(key);
        if (remove == null) {
            return null;
        }
        Collection<V> A0D = this.A01.A0D();
        A0D.addAll(remove);
        C2L.A03(this.A01, remove.size());
        remove.clear();
        return A0D;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // com.instagram.common.viewpoint.core.AbstractC2458pn
    public final Set<Map.Entry<K, Collection<V>>> A09() {
        return new BI<K, Collection<V>>() { // from class: com.facebook.ads.redexgen.X.2P
            public static String[] A01 = {"c", "Cderzo7kRJnvUqpU20WcBh2OZWVVjooT", "Z", "ZZrF4bQPE17IkUPu05dPNeIYxEP3htEV", "zoL9Bw1Syr4GOxCjTnDxY342EbanM9q3", "GegVcEhGdWXR", "86lf1o9WQgzrbD", "NgZwPtD5hXQhY3eRyOKbKp0yAyP86bbs"};

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2P != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap$AsMapEntries */
            @Override // com.instagram.common.viewpoint.core.BI
            public final Map<K, Collection<V>> A00() {
                return C0900Bt.this;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2P != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap$AsMapEntries */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(@CheckForNull Object o) {
                return AbstractC2325nc.A03(C0900Bt.this.A00.entrySet(), o);
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2P != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap$AsMapEntries */
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C2223ll(C0900Bt.this);
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2P != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap$AsMapEntries */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object o) {
                if (!contains(o)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) Objects.requireNonNull((Map.Entry) o);
                C0900Bt c0900Bt = C0900Bt.this;
                if (A01[2].length() == 19) {
                    throw new RuntimeException();
                }
                A01[3] = "G2qcJwlII5HIikaXRsYLysr3qmkTj7oM";
                c0900Bt.A01.A0A(entry.getKey());
                return true;
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    public final Map.Entry<K, Collection<V>> A0A(Map.Entry<K, Collection<V>> entry) {
        K key = entry.getKey();
        return AbstractC2459po.A01(key, this.A01.A0F(key, entry.getValue()));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Map<K, Collection<V>> map;
        Map<K, Collection<V>> map2 = this.A00;
        map = this.A01.A01;
        if (map2 == map) {
            this.A01.clear();
        } else {
            AbstractC2419p9.A09(new C2223ll(this));
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object key) {
        return AbstractC2459po.A0C(this.A00, key);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(@CheckForNull Object object) {
        return this == object || this.A00.equals(object);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.A00.hashCode();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return this.A01.A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.A00.size();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.google.common.collect.AbstractMapBasedMultimap<K, V>$AsMap */
    @Override // java.util.AbstractMap
    public final String toString() {
        return this.A00.toString();
    }
}
