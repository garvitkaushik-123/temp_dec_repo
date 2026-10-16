package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.io.Serializable;

@ElementTypesAreNonnullByDefault
/* loaded from: assets/audience_network/classes2.dex */
public class BQ<K, V> extends AbstractC2229lr<K, V> implements Serializable {
    public static final long serialVersionUID = 0;

    @ParametricNullness
    public final K A00;

    @ParametricNullness
    public final V A01;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BQ != com.google.common.collect.ImmutableEntry<K, V> */
    public BQ(@ParametricNullness K key, @ParametricNullness V value) {
        this.A00 = key;
        this.A01 = value;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BQ != com.google.common.collect.ImmutableEntry<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2229lr, java.util.Map.Entry
    @ParametricNullness
    public final K getKey() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BQ != com.google.common.collect.ImmutableEntry<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2229lr, java.util.Map.Entry
    @ParametricNullness
    public final V getValue() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BQ != com.google.common.collect.ImmutableEntry<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2229lr, java.util.Map.Entry
    @ParametricNullness
    public final V setValue(@ParametricNullness V value) {
        throw new UnsupportedOperationException();
    }
}
