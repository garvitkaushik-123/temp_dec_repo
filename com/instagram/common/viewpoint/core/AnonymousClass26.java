package com.instagram.common.viewpoint.core;

import com.google.common.collect.ParametricNullness;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* renamed from: com.facebook.ads.redexgen.X.26, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public class AnonymousClass26<E> extends C0876Av<E> implements SortedSet<E> {
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.26 != com.google.common.collect.Sets$FilteredSortedSet<E> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super E> */
    public AnonymousClass26(SortedSet<E> unfiltered, InterfaceC2160kj<? super E> predicate) {
        super(unfiltered, predicate);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.26 != com.google.common.collect.Sets$FilteredSortedSet<E> */
    @Override // java.util.SortedSet
    @CheckForNull
    public final Comparator<? super E> comparator() {
        return ((SortedSet) this.A01).comparator();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.26 != com.google.common.collect.Sets$FilteredSortedSet<E> */
    @Override // java.util.SortedSet
    @ParametricNullness
    public final E first() {
        return (E) AbstractC2419p9.A05(this.A01.iterator(), this.A00);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.26 != com.google.common.collect.Sets$FilteredSortedSet<E> */
    @Override // java.util.SortedSet
    public final SortedSet<E> headSet(@ParametricNullness E toElement) {
        return new AnonymousClass26(((SortedSet) this.A01).headSet(toElement), this.A00);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.26 != com.google.common.collect.Sets$FilteredSortedSet<E> */
    @Override // java.util.SortedSet
    @ParametricNullness
    public E last() {
        SortedSet sortedSet = (SortedSet) this.A01;
        while (true) {
            E e = (Object) sortedSet.last();
            if (this.A00.A4C(e)) {
                return e;
            }
            sortedSet = sortedSet.headSet(e);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.26 != com.google.common.collect.Sets$FilteredSortedSet<E> */
    @Override // java.util.SortedSet
    public final SortedSet<E> subSet(@ParametricNullness E fromElement, @ParametricNullness E toElement) {
        return new AnonymousClass26(((SortedSet) this.A01).subSet(fromElement, toElement), this.A00);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.26 != com.google.common.collect.Sets$FilteredSortedSet<E> */
    @Override // java.util.SortedSet
    public final SortedSet<E> tailSet(@ParametricNullness E fromElement) {
        return new AnonymousClass26(((SortedSet) this.A01).tailSet(fromElement), this.A00);
    }
}
