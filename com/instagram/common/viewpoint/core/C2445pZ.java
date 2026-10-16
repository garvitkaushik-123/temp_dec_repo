package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.pZ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2445pZ implements AnonymousClass24 {
    public final int A00;
    public final C2452pg A01;
    public final boolean A02;
    public final int[] A03;
    public final boolean[] A04;
    public static final String A07 = C5C.A0h(0);
    public static final String A09 = C5C.A0h(1);
    public static final String A08 = C5C.A0h(3);
    public static final String A06 = C5C.A0h(4);
    public static final AnonymousClass23<C2445pZ> A05 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pa
        @Override // com.instagram.common.viewpoint.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C2445pZ.A00(bundle);
        }
    };

    public C2445pZ(C2452pg c2452pg, boolean z, int[] iArr, boolean[] zArr) {
        this.A00 = c2452pg.A01;
        boolean z2 = false;
        AbstractC07133y.A07(this.A00 == iArr.length && this.A00 == zArr.length);
        this.A01 = c2452pg;
        if (z && this.A00 > 1) {
            z2 = true;
        }
        this.A02 = z2;
        this.A03 = (int[]) iArr.clone();
        this.A04 = (boolean[]) zArr.clone();
    }

    public static /* synthetic */ C2445pZ A00(Bundle bundle) {
        C2452pg A6f = C2452pg.A06.A6f((Bundle) AbstractC07133y.A01(bundle.getBundle(A07)));
        int[] iArr = (int[]) AbstractC2152ka.A00(bundle.getIntArray(A09), new int[A6f.A01]);
        boolean[] selected = (boolean[]) AbstractC2152ka.A00(bundle.getBooleanArray(A08), new boolean[A6f.A01]);
        return new C2445pZ(A6f, bundle.getBoolean(A06, false), iArr, selected);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2445pZ c2445pZ = (C2445pZ) obj;
        if (this.A02 == c2445pZ.A02 && this.A01.equals(c2445pZ.A01) && Arrays.equals(this.A03, c2445pZ.A03) && Arrays.equals(this.A04, c2445pZ.A04)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.A01.hashCode() * 31) + (this.A02 ? 1 : 0)) * 31) + Arrays.hashCode(this.A03)) * 31) + Arrays.hashCode(this.A04);
    }
}
