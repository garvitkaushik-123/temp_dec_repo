package com.instagram.common.viewpoint.core;

import com.google.common.base.ElementTypesAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.kp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2166kp {
    public final int A00;
    public final CC A01;
    public final InterfaceC2165ko A02;
    public final boolean A03;

    public C2166kp(InterfaceC2165ko strategy) {
        this(strategy, false, CC.A03(), Integer.MAX_VALUE);
    }

    public C2166kp(InterfaceC2165ko strategy, boolean omitEmptyStrings, CC trimmer, int limit) {
        this.A02 = strategy;
        this.A03 = omitEmptyStrings;
        this.A01 = trimmer;
        this.A00 = limit;
    }

    public static C2166kp A02(char separator) {
        return A03(CC.A02(separator));
    }

    public static C2166kp A03(final CC separatorMatcher) {
        AbstractC2159ki.A04(separatorMatcher);
        return new C2166kp(new C3(separatorMatcher));
    }

    private Iterator<String> A04(CharSequence sequence) {
        return this.A02.AAl(this, sequence);
    }

    public final List<String> A06(CharSequence sequence) {
        AbstractC2159ki.A04(sequence);
        Iterator<String> A04 = A04(sequence);
        List<String> result = new ArrayList<>();
        while (A04.hasNext()) {
            result.add(A04.next());
        }
        return Collections.unmodifiableList(result);
    }
}
