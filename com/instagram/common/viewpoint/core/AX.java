package com.instagram.common.viewpoint.core;

import android.os.Bundle;

/* loaded from: assets/audience_network/classes2.dex */
public final class AX extends AbstractC2464pt {
    public final boolean A00;
    public final boolean A01;
    public static final String A04 = C5C.A0h(1);
    public static final String A03 = C5C.A0h(2);
    public static final AnonymousClass23<AX> A02 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.qH
        @Override // com.instagram.common.viewpoint.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            AX A00;
            A00 = AX.A00(bundle);
            return A00;
        }
    };

    public AX() {
        this.A01 = false;
        this.A00 = false;
    }

    public AX(boolean z) {
        this.A01 = true;
        this.A00 = z;
    }

    public static AX A00(Bundle bundle) {
        boolean isRated = bundle.getInt(AbstractC2464pt.A02, -1) == 0;
        AbstractC07133y.A07(isRated);
        boolean isRated2 = bundle.getBoolean(A04, false);
        if (isRated2) {
            return new AX(bundle.getBoolean(A03, false));
        }
        return new AX();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AX)) {
            return false;
        }
        AX ax = (AX) obj;
        return this.A00 == ax.A00 && this.A01 == ax.A01;
    }

    public final int hashCode() {
        return CB.A00(Boolean.valueOf(this.A01), Boolean.valueOf(this.A00));
    }
}
