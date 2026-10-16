package com.instagram.common.viewpoint.core;

import android.animation.ObjectAnimator;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.bM, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1599bM implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C6U A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 45);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.FF, 1, Ascii.GS, 5, Ascii.FF};
    }

    public RunnableC1599bM(C6U c6u) {
        this.A00 = c6u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String A00 = A00(0, 5, 64);
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0U.A0F().AKi();
            ObjectAnimator.ofFloat(this.A00.A0Q, A00, 1.0f, 0.0f).setDuration(100L).start();
            ObjectAnimator.ofFloat(this.A00.A0P, A00, 1.0f, 0.0f).setDuration(100L).start();
            ObjectAnimator duration = ObjectAnimator.ofFloat(((AbstractC1592bF) this.A00).A09, A00, 1.0f, 0.0f).setDuration(100L);
            duration.addListener(new C1598bL(this));
            duration.start();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
