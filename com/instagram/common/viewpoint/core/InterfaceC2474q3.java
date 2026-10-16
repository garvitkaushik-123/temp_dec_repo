package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;

@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.q3, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC2474q3<K, V> {
    Map<K, Collection<V>> A4H();

    boolean AHE(@ParametricNullness K key, @ParametricNullness V value);

    void clear();

    int size();

    Collection<V> values();
}
