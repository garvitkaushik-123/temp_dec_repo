package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.nH, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2304nH implements AnonymousClass24 {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int[] A03;
    public static String[] A04 = {"0EeRaofkOnG82pPuB", "jcjJv", "T4n", "y6LXg9kPowsRJwalOEx6K", "cypgHvauDeb", "sGCac32Lryl6ta5A9qPel0ZSNDpSTc", "mAWrtqCYM7sM8yItQ0fM", "xdW2EE8FfL1ekapcbmlM6yOkR5Ux1S1"};
    public static final String A06 = C5C.A0h(0);
    public static final String A07 = C5C.A0h(1);
    public static final String A08 = C5C.A0h(2);
    public static final AnonymousClass23<C2304nH> A05 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.nI
        @Override // com.instagram.common.viewpoint.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C2304nH.A00(bundle);
        }
    };

    public C2304nH(int i, int[] iArr, int i2) {
        this.A00 = i;
        this.A03 = Arrays.copyOf(iArr, iArr.length);
        this.A01 = iArr.length;
        this.A02 = i2;
        Arrays.sort(this.A03);
    }

    public static /* synthetic */ C2304nH A00(Bundle bundle) {
        int i = bundle.getInt(A06, -1);
        int[] tracks = bundle.getIntArray(A07);
        int trackType = bundle.getInt(A08, -1);
        AbstractC07133y.A07(i >= 0 && trackType >= 0);
        AbstractC07133y.A01(tracks);
        return new C2304nH(i, tracks, trackType);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        String[] strArr = A04;
        if (strArr[5].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        A04[6] = "RoyHwRFBbL3TyB1YuYs";
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2304nH c2304nH = (C2304nH) obj;
        if (this.A00 == c2304nH.A00 && Arrays.equals(this.A03, c2304nH.A03) && this.A02 == c2304nH.A02) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((this.A00 * 31) + Arrays.hashCode(this.A03)) * 31;
        int hash = this.A02;
        return hashCode + hash;
    }
}
