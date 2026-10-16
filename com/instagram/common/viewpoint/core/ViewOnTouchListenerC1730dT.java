package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.dT, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1730dT implements View.OnTouchListener {
    public static byte[] A01;
    public static String[] A02 = {"1JwnbZc", "kkmIQJqvWiBwk9jfILYgPIrgQCS38owh", "N8yLaPVokkuJ1YkIyuCF7aIX6VfLiVBd", "jm5vdlZ72Lbf6a1gReW0ha76qwb04vv", "DCC4I5JAGBbf78VQRaqWv8G", "3hSFZU1sfTZMtq4oO1UMPPTcQg0VdY6I", "fV1nhS4pYMKgLfTP54XPcsPXLQx3eWXA", "qgSXXDY"};
    public final /* synthetic */ C5F A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 29);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.DLE, Ascii.SO, 0, Ascii.CR, -6, -2, 7, 4, -2, 6, -6, 4, -4, -3, -12, -14, -28, -15, -34, -22, -28, -8, -17, -32, -29, -34, -30, -21, -24, -30, -22, -34, -24, -32, -31};
    }

    static {
        A01();
    }

    public ViewOnTouchListenerC1730dT(C5F c5f) {
        this.A00 = c5f;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        InputMethodManager inputMethodManager;
        InputMethodManager inputMethodManager2;
        boolean z2;
        int i;
        switch (motionEvent.getActionMasked()) {
            case 0:
                z = this.A00.A0O;
                if (!z) {
                    inputMethodManager = this.A00.A09;
                    if (inputMethodManager == null) {
                        return false;
                    }
                    C5F c5f = this.A00;
                    if (A02[6].charAt(16) == 'R') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A02;
                    strArr[0] = "d6v6uEk";
                    strArr[7] = "mdHpVNv";
                    inputMethodManager2 = c5f.A09;
                    if (inputMethodManager2.isAcceptingText()) {
                        this.A00.A0O = true;
                        this.A00.A0i(A00(14, 21, 98));
                        return false;
                    }
                    return false;
                }
                return false;
            case 1:
                C5F.A07(this.A00);
                z2 = this.A00.A0N;
                if (A02[2].charAt(15) == 'o') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[0] = "JX78O96";
                strArr2[7] = "bIdbL9K";
                if (!z2) {
                    i = this.A00.A07;
                    if (i >= 5) {
                        this.A00.A0N = true;
                        this.A00.A0i(A00(0, 14, 126));
                        return false;
                    }
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
