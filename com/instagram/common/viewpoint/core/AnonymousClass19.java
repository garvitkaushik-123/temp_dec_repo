package com.instagram.common.viewpoint.core;

import com.google.common.collect.ParametricNullness;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* renamed from: com.facebook.ads.redexgen.X.19, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass19<K, V> extends C2L<K, V>.SortedAsMap implements NavigableMap<K, Collection<V>> {
    public final /* synthetic */ C2L A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @CheckForNull
    private final Map.Entry<K, Collection<V>> A01(Iterator<Map.Entry<K, Collection<V>>> entryIterator) {
        if (!entryIterator.hasNext()) {
            return null;
        }
        Map.Entry<K, Collection<V>> next = entryIterator.next();
        Collection<V> A0D = this.A00.A0D();
        A0D.addAll(next.getValue());
        entryIterator.remove();
        return AbstractC2459po.A01(next.getKey(), this.A00.A0G(A0D));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, Collection<V>> ceilingEntry(@ParametricNullness K key) {
        Map.Entry<K, Collection<V>> ceilingEntry = A0B().ceilingEntry(key);
        if (ceilingEntry == null) {
            return null;
        }
        return A0A(ceilingEntry);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, Collection<V>> firstEntry() {
        Map.Entry<K, Collection<V>> firstEntry = A0B().firstEntry();
        if (firstEntry == null) {
            return null;
        }
        return A0A(firstEntry);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, Collection<V>> floorEntry(@ParametricNullness K key) {
        Map.Entry<K, Collection<V>> floorEntry = A0B().floorEntry(key);
        if (floorEntry == null) {
            return null;
        }
        return A0A(floorEntry);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, Collection<V>> higherEntry(@ParametricNullness K key) {
        Map.Entry<K, Collection<V>> higherEntry = A0B().higherEntry(key);
        if (higherEntry == null) {
            return null;
        }
        return A0A(higherEntry);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, Collection<V>> lastEntry() {
        Map.Entry<K, Collection<V>> lastEntry = A0B().lastEntry();
        if (lastEntry == null) {
            return null;
        }
        return A0A(lastEntry);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, Collection<V>> lowerEntry(@ParametricNullness K key) {
        Map.Entry<K, Collection<V>> lowerEntry = A0B().lowerEntry(key);
        if (lowerEntry == null) {
            return null;
        }
        return A0A(lowerEntry);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    public AnonymousClass19(final C2L this$0, NavigableMap<K, Collection<V>> submap) {
        super(this$0, submap);
        this.A00 = this$0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final NavigableSet<K> A0C() {
        return new C0u(this.A00, A0B());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final NavigableMap<K, Collection<V>> A0B() {
        return (NavigableMap) super.A0B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final NavigableMap<K, Collection<V>> headMap(@ParametricNullness K toKey) {
        return headMap(toKey, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K fromKey) {
        return tailMap(fromKey, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final NavigableMap<K, Collection<V>> subMap(@ParametricNullness K fromKey, @ParametricNullness K toKey) {
        return subMap(fromKey, true, toKey, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.SortedMap, java.util.Map
    /* renamed from: A06, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final K ceilingKey(@ParametricNullness K key) {
        return A0B().ceilingKey(key);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    public final NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    public final NavigableMap<K, Collection<V>> descendingMap() {
        return new AnonymousClass19(this.A00, A0B().descendingMap());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final K floorKey(@ParametricNullness K key) {
        return A0B().floorKey(key);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    public final NavigableMap<K, Collection<V>> headMap(@ParametricNullness K toKey, boolean inclusive) {
        return new AnonymousClass19(this.A00, A0B().headMap(toKey, inclusive));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final K higherKey(@ParametricNullness K key) {
        return A0B().higherKey(key);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final K lowerKey(@ParametricNullness K key) {
        return A0B().lowerKey(key);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    public final NavigableSet<K> navigableKeySet() {
        return keySet();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, Collection<V>> pollFirstEntry() {
        return A01(entrySet().iterator());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, Collection<V>> pollLastEntry() {
        return A01(descendingMap().entrySet().iterator());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    public final NavigableMap<K, Collection<V>> subMap(@ParametricNullness K fromKey, @ParametricNullness boolean fromInclusive, K toKey, boolean toInclusive) {
        return new AnonymousClass19(this.A00, A0B().subMap(fromKey, fromInclusive, toKey, toInclusive));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.19 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$NavigableAsMap */
    @Override // java.util.NavigableMap
    public final NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K fromKey, boolean inclusive) {
        return new AnonymousClass19(this.A00, A0B().tailMap(fromKey, inclusive));
    }
}
