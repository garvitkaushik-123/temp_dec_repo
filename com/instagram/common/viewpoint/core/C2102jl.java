package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.jl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2102jl extends N3 {
    public static byte[] A06;
    public static final String A07;
    public C2104jn A00;
    public EnumC1403Vp A01;
    public boolean A02;
    public final C1929gi A03;
    public final VA A04;
    public final AbstractC1575ay A05;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{-55, -56, -43, -43, -52, -39};
    }

    static {
        A05();
        A07 = C2102jl.class.getSimpleName();
    }

    public C2102jl(C1929gi c1929gi, VA va, AbstractC1575ay abstractC1575ay, C1874fp c1874fp, N4 n4, EnumC1403Vp enumC1403Vp) {
        super(c1929gi, n4, c1874fp);
        this.A04 = va;
        this.A05 = abstractC1575ay;
        this.A03 = c1929gi;
        this.A01 = enumC1403Vp;
    }

    @Override // com.instagram.common.viewpoint.core.N3
    public final void A08(Map<String, String> map) {
        String adPlacementType;
        if (this.A00 != null && !TextUtils.isEmpty(this.A00.A7O())) {
            this.A03.A0F().A3L();
            AbstractC1213Oa.A02(this.A00.A05(), AbstractC1449Xm.A00(A04(0, 6, 50)));
            this.A04.ABJ(this.A00.A7O(), map);
            if (C1379Up.A1A(this.A03)) {
                if (this.A01 == EnumC1403Vp.A09) {
                    adPlacementType = AdPlacementType.MEDIUM_RECTANGLE.toString();
                } else {
                    adPlacementType = AdPlacementType.BANNER.toString();
                }
                C1425Wl A00 = C1425Wl.A00(this.A03);
                String placementType = this.A00.A7O();
                A00.A0E(adPlacementType, placementType);
            }
        }
    }

    public final synchronized void A09() {
        if (!this.A02 && this.A00 != null) {
            this.A02 = true;
            if (!TextUtils.isEmpty(this.A00.A03())) {
                Y4.A00(new C2103jm(this));
            }
        }
    }

    public final void A0A(C2104jn c2104jn) {
        this.A00 = c2104jn;
    }
}
