package com.instagram.common.viewpoint.core;

import com.google.common.base.ParametricNullness;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.CheckForNull;

/* loaded from: assets/audience_network/classes2.dex */
public class C9<T> implements InterfaceC2160kj<T>, Serializable {
    public static byte[] A01;
    public static final long serialVersionUID = 0;
    public final List<? extends InterfaceC2160kj<? super T>> A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 99);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{52, 65, 55};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    public C9(List<? extends InterfaceC2160kj<? super T>> components) {
        this.A00 = components;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    /* JADX WARN: Incorrect condition in loop: B:3:0x0007 */
    @Override // com.instagram.common.viewpoint.core.InterfaceC2160kj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A4C(@ParametricNullness T t) {
        for (int i = 0; i < i; i++) {
            if (!this.A00.get(i).A4C(t)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<?> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof C9) {
            return this.A00.equals(((C9) obj).A00);
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    public final int hashCode() {
        return this.A00.hashCode() + 306654252;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    public final String toString() {
        String A02;
        A02 = AbstractC2162kl.A02(A00(0, 3, 112), this.A00);
        return A02;
    }
}
