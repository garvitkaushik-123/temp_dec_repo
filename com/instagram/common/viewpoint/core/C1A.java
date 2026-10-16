package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.1A, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class C1A<K, V> extends C2L<K, V> implements BM<K, V> {
    public static final long serialVersionUID = 6588350623831699109L;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.C2L
    public final Collection<V> A0F(@ParametricNullness K key, Collection<V> collection) {
        return A0H(key, (List) collection, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1A != com.google.common.collect.AbstractListMultimap<K, V> */
    public C1A(Map<K, Collection<V>> map) {
        super(map);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1A != com.google.common.collect.AbstractListMultimap<K, V> */
    @Override // com.instagram.common.viewpoint.core.C2L
    public final <E> Collection<E> A0G(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1A != com.google.common.collect.AbstractListMultimap<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC0897Bq, com.instagram.common.viewpoint.core.InterfaceC2474q3
    public Map<K, Collection<V>> A4H() {
        return super.A4H();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1A != com.google.common.collect.AbstractListMultimap<K, V> */
    @Override // com.instagram.common.viewpoint.core.C2L, com.instagram.common.viewpoint.core.InterfaceC2474q3
    public boolean AHE(@ParametricNullness K key, @ParametricNullness V value) {
        return super.AHE(key, value);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1A != com.google.common.collect.AbstractListMultimap<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC0897Bq
    public boolean equals(@CheckForNull Object object) {
        return super.equals(object);
    }
}
