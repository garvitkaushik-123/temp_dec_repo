package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.dr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1753dr implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C4V A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 41);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{89, 84, 80, 85, 84, 67};
    }

    public ViewOnClickListenerC1753dr(C4V c4v) {
        this.A00 = c4v;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AbstractC1642c3 abstractC1642c3;
        AbstractC1642c3 abstractC1642c32;
        if (WU.A02(this)) {
            return;
        }
        try {
            abstractC1642c3 = this.A00.A02;
            if (abstractC1642c3 != null) {
                abstractC1642c32 = this.A00.A02;
                abstractC1642c32.A1B(A00(0, 6, 24));
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
