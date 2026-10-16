package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.c2, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1641c2 implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C6K A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{53, 49, Base64.padSymbol, 59, 57};
    }

    public ViewOnClickListenerC1641c2(C6K c6k) {
        this.A00 = c6k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.getCtaButton().A0E(A00(0, 5, 34));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
