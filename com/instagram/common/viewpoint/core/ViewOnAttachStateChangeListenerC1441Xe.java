package com.instagram.common.viewpoint.core;

import android.view.View;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Xe, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class ViewOnAttachStateChangeListenerC1441Xe extends AbstractC2536rL implements View.OnAttachStateChangeListener {
    public static byte[] A02;
    public final View A00;
    public final C1925ge A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 40);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Byte.MAX_VALUE, SignedBytes.MAX_POWER_OF_TWO, 76, 94, 89, 70, SignedBytes.MAX_POWER_OF_TWO, 71, 93, 9, Byte.MAX_VALUE, SignedBytes.MAX_POWER_OF_TWO, 76, 94, 9, 69, SignedBytes.MAX_POWER_OF_TWO, 79, 76, 74, 80, 74, 69, 76, 9, 74, 91, 72, 90, 65, SignedBytes.MAX_POWER_OF_TWO, 71, 78, 9, 90, 93, 72, 91, 93, 122, 74, 72, 71, 9, 9, Ascii.VT, 52, 56, 42, 45, 50, 52, 51, 41, 125, Ascii.VT, 52, 56, 42, 125, 49, 52, 59, 56, 62, 36, 62, 49, 56, 125, 62, 47, 60, 46, 53, 52, 51, 58, 125, 46, 41, 60, 47, 41, Ascii.SO, 62, 60, 51, 19, 50, 42, 125, 125, 103, 88, 84, 70, 65, 94, 88, 95, 69, 17, 103, 88, 84, 70, 17, 93, 88, 87, 84, 82, 72, 82, 93, 84, 17, 82, 67, 80, 66, 89, 88, 95, 86, 17, 66, 69, 94, 65, 98, 82, 80, 95, 17, 17, 8, Ascii.RS, Ascii.CAN, Ascii.DC4, Ascii.NAK, Ascii.US, 36, Ascii.CAN, 19, Ascii.SUB, Ascii.NAK, Ascii.NAK, Ascii.RS, Ascii.ETB};
    }

    public ViewOnAttachStateChangeListenerC1441Xe(View view, C1925ge c1925ge) {
        this.A00 = view;
        this.A01 = c1925ge;
        this.A00.addOnAttachStateChangeListener(this);
        if (A05()) {
            try {
                A00();
            } catch (Throwable th) {
                this.A01.A08().ABC(A00(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 14, 83), 3600, new C1342Te(A00(0, 45, 1) + th.getMessage()));
            }
        }
    }

    public final void A04() {
        try {
            A00();
        } catch (Throwable th) {
            this.A01.A08().ABC(A00(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 14, 83), 3600, new C1342Te(A00(45, 48, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) + th.getMessage()));
        }
    }

    public final boolean A05() {
        return Ph.A0H(this.A00);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        try {
            A00();
        } catch (Throwable th) {
            this.A01.A08().ABC(A00(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 14, 83), 3600, new C1342Te(A00(0, 45, 1) + th.getMessage()));
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        try {
            A02();
        } catch (Throwable th) {
            this.A01.A08().ABC(A00(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 14, 83), 3600, new C1342Te(A00(93, 44, 25) + th.getMessage()));
        }
    }
}
