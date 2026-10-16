package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* loaded from: assets/audience_network/classes2.dex */
public final class N6 {
    public static N1 A00;

    public final N1 A00(final C1929gi c1929gi, AdPlacementType adPlacementType) {
        if (A00 != null) {
            return A00;
        }
        switch (N5.A00[adPlacementType.ordinal()]) {
            case 1:
                return new AnonymousClass81();
            case 2:
                if (C1379Up.A1O(c1929gi)) {
                    return new AnonymousClass80();
                }
                return new AnonymousClass81();
            case 3:
                return new C2116jz();
            case 4:
                return new C2111ju(c1929gi);
            case 5:
                return new C2111ju(c1929gi) { // from class: com.facebook.ads.redexgen.X.7z
                    @Override // com.instagram.common.viewpoint.core.C2111ju, com.instagram.common.viewpoint.core.N1
                    public final AdPlacementType A8k() {
                        return AdPlacementType.NATIVE_BANNER;
                    }
                };
            case 6:
                return new C08157w();
            default:
                return null;
        }
    }
}
