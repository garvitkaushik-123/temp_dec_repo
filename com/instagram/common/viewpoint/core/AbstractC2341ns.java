package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.ns, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2341ns {
    public static final AbstractC2341ns A00 = new C0885Be();
    public static final AbstractC2341ns A02 = new C0883Bc(-1);
    public static final AbstractC2341ns A01 = new C0883Bc(1);

    public abstract int A05();

    public abstract AbstractC2341ns A06(int left, int right);

    public abstract AbstractC2341ns A07(long left, long right);

    public abstract <T> AbstractC2341ns A08(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator);

    public abstract AbstractC2341ns A09(boolean left, boolean right);

    public abstract AbstractC2341ns A0A(boolean left, boolean right);

    public AbstractC2341ns() {
    }

    public /* synthetic */ AbstractC2341ns(C0885Be c0885Be) {
        this();
    }

    public static AbstractC2341ns A01() {
        return A00;
    }
}
