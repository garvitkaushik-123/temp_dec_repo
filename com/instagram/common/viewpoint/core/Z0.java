package com.instagram.common.viewpoint.core;

import android.view.View;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class Z0 implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ Z2 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 108);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{124, 120, 116, 114, 112};
    }

    public Z0(Z2 z2) {
        this.A00 = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C1235Ow c1235Ow;
        if (WU.A02(this)) {
            return;
        }
        try {
            c1235Ow = this.A00.A07;
            c1235Ow.getCTAButton().A0E(A00(0, 5, Sdk.SDKError.Reason.TPAT_ERROR_VALUE));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
