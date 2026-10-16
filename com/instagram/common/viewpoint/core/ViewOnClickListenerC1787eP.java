package com.instagram.common.viewpoint.core;

import android.view.View;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.eP, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1787eP implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C1790eS A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 77);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{4, Ascii.SI, 5, 2, 0, 19, 5, Ascii.DC2};
    }

    public ViewOnClickListenerC1787eP(C1790eS c1790eS) {
        this.A00 = c1790eS;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr;
        ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr2;
        if (WU.A02(this)) {
            return;
        }
        try {
            viewOnClickListenerC1127Kr = this.A00.A0l;
            if (viewOnClickListenerC1127Kr == null) {
                return;
            }
            viewOnClickListenerC1127Kr2 = this.A00.A0l;
            viewOnClickListenerC1127Kr2.A0E(A00(0, 8, 44));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
