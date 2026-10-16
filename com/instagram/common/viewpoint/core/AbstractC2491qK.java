package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.qK, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2491qK<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public abstract int compare(@ParametricNullness T left, @ParametricNullness T right);

    public static <C extends Comparable> AbstractC2491qK<C> A03() {
        return BB.A02;
    }

    public static <T> AbstractC2491qK<T> A04(Comparator<T> comparator) {
        if (comparator instanceof AbstractC2491qK) {
            return (AbstractC2491qK) comparator;
        }
        return new C0888Bh(comparator);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kO != com.google.common.base.Function<F, ? extends T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qK != com.google.common.collect.Ordering<T> */
    public final <F> AbstractC2491qK<F> A05(InterfaceC2140kO<F, ? extends T> function) {
        return new C0896Bp(function, this);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qK != com.google.common.collect.Ordering<T> */
    public <S extends T> AbstractC2491qK<S> A06() {
        return new B2(this);
    }
}
