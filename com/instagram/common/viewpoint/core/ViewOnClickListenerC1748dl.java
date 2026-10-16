package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.dl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1748dl implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C1011Ge A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 66);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{126, 115, 119, 114, 115, 100};
    }

    public ViewOnClickListenerC1748dl(C1011Ge c1011Ge) {
        this.A00 = c1011Ge;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AbstractC1068Ij abstractC1068Ij;
        AbstractC1068Ij abstractC1068Ij2;
        if (WU.A02(this)) {
            return;
        }
        try {
            abstractC1068Ij = this.A00.A04;
            if (abstractC1068Ij != null) {
                abstractC1068Ij2 = this.A00.A04;
                abstractC1068Ij2.A1D(A00(0, 6, 84));
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
