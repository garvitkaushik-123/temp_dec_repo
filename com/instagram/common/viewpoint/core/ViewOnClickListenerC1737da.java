package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.da, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1737da implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass55 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 65);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-84, -81, -81, -80, -65, -84, -76, -73, -66};
    }

    public ViewOnClickListenerC1737da(AnonymousClass55 anonymousClass55) {
        this.A00 = anonymousClass55;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        InterfaceC1749dm interfaceC1749dm;
        if (WU.A02(this)) {
            return;
        }
        try {
            z = this.A00.A0D;
            if (!z) {
                this.A00.A0t(A00(0, 9, 10));
                interfaceC1749dm = this.A00.A0Z;
                interfaceC1749dm.ACQ();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
