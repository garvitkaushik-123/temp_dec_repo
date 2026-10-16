package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.1d, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC06441d<F, T> implements Iterator<T> {
    public final Iterator<? extends F> A00;

    @ParametricNullness
    public abstract T A01(@ParametricNullness F from);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1d != com.google.common.collect.TransformedIterator<F, T> */
    public AbstractC06441d(Iterator<? extends F> backingIterator) {
        this.A00 = (Iterator) AbstractC2159ki.A04(backingIterator);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1d != com.google.common.collect.TransformedIterator<F, T> */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00.hasNext();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1d != com.google.common.collect.TransformedIterator<F, T> */
    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        return A01(this.A00.next());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1d != com.google.common.collect.TransformedIterator<F, T> */
    @Override // java.util.Iterator
    public final void remove() {
        this.A00.remove();
    }
}
