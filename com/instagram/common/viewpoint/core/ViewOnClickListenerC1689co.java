package com.instagram.common.viewpoint.core;

import android.view.View;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.co, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1689co implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C1092Ji A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 64);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.ETB, 19, Ascii.US, Ascii.EM, Ascii.ESC};
    }

    public ViewOnClickListenerC1689co(C1092Ji c1092Ji) {
        this.A00 = c1092Ji;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C1646c7 c1646c7;
        C1646c7 c1646c72;
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0p(A00(0, 5, 62));
            c1646c7 = this.A00.A0b;
            if (c1646c7.A0D() != null) {
                c1646c72 = this.A00.A0b;
                c1646c72.A0D().ACQ();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
