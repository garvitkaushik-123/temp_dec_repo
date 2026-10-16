package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.ListIterator;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.Au, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0875Au<E> extends C4C<E> implements ListIterator<E> {
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Au != com.google.common.collect.UnmodifiableListIterator<E> */
    @Override // java.util.ListIterator
    @Deprecated
    public final void add(@ParametricNullness E e) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Au != com.google.common.collect.UnmodifiableListIterator<E> */
    @Override // java.util.ListIterator
    @Deprecated
    public final void set(@ParametricNullness E e) {
        throw new UnsupportedOperationException();
    }
}
