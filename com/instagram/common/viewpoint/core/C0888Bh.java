package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.Bh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0888Bh<T> extends AbstractC2491qK<T> implements Serializable {
    public static String[] A01 = {"jVomwQRsen5vglXLuhXzBdwbPq6Ybrnn", "4aFITO9kz2LhtcD79HHzI", "vi18DojAtNgr3DJJSarcVnM7GKn6nndK", "ML5KuQXC", "N0lS1ni31cQ1TBeJZ0107lcHpyRIIPod", "312TaVRQAIGqwiXD4iywzyjTEypEIgK4", "JELmBa89yxiLk2CDuF87Yo0NIlkJ44v9", "QWcb8PBY5hKO"};
    public static final long serialVersionUID = 0;
    public final Comparator<T> A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bh != com.google.common.collect.ComparatorOrdering<T> */
    public C0888Bh(Comparator<T> comparator) {
        this.A00 = (Comparator) AbstractC2159ki.A04(comparator);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bh != com.google.common.collect.ComparatorOrdering<T> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2491qK, java.util.Comparator
    public final int compare(@ParametricNullness T a2, @ParametricNullness T b) {
        return this.A00.compare(a2, b);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bh != com.google.common.collect.ComparatorOrdering<?> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bh != com.google.common.collect.ComparatorOrdering<T> */
    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof C0888Bh) {
            return this.A00.equals(((C0888Bh) object).A00);
        }
        String[] strArr = A01;
        if (strArr[0].charAt(22) == strArr[5].charAt(22)) {
            throw new RuntimeException();
        }
        A01[7] = "MG7YcOvDvuMg";
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bh != com.google.common.collect.ComparatorOrdering<T> */
    public final int hashCode() {
        return this.A00.hashCode();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bh != com.google.common.collect.ComparatorOrdering<T> */
    public final String toString() {
        return this.A00.toString();
    }
}
