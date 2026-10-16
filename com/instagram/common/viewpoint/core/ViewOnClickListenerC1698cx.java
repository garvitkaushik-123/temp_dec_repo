package com.instagram.common.viewpoint.core;

import android.view.View;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.cx, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1698cx implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass67 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 59);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{36, Ascii.ETB, Ascii.DC2, 19, Ascii.GS};
    }

    public ViewOnClickListenerC1698cx(AnonymousClass67 anonymousClass67) {
        this.A00 = anonymousClass67;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.getCtaButton().A0E(A00(0, 5, 115));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
