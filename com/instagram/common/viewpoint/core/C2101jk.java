package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.jk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2101jk extends N3 {
    public static byte[] A02;

    @Nullable
    public final C2099ji A00;
    public final VA A01;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 26);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{70, 69, 74, 74, 65, 86};
    }

    public C2101jk(C1929gi c1929gi, N4 n4, C1874fp c1874fp, VA va, C2099ji c2099ji) {
        super(c1929gi, n4, c1874fp);
        this.A01 = va;
        this.A00 = c2099ji;
    }

    @Override // com.instagram.common.viewpoint.core.N3
    public final void A08(Map<String, String> map) {
        if (this.A00 != null && !TextUtils.isEmpty(this.A00.A7O())) {
            this.A02.A0F().A3L();
            AbstractC1213Oa.A02(this.A00.A0a(), AbstractC1449Xm.A00(A01(0, 6, 62)));
            this.A01.ABJ(this.A00.A7O(), map);
            if (C1379Up.A1A(this.A02)) {
                String adPlacementType = AdPlacementType.MEDIUM_RECTANGLE.toString();
                C1425Wl A00 = C1425Wl.A00(this.A02);
                String placementType = this.A00.A7O();
                A00.A0E(adPlacementType, placementType);
            }
        }
    }
}
