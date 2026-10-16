package com.instagram.common.viewpoint.core;

import android.view.View;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.eY, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1795eY implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"6oymiTsLeOB6akVZhYZlzt9u0lzod266", "zcFrhgW", "pA0IIkGKiekAr0fjB", "y6hjg8mxqAalWUMcxQuHYQOItnPT39hG", "7U0TsM6", "Tg7m67O8vHVp5z623KOmUlfZNUrkO0e2", "eZwTRoaquQnWH3ejc5rSlBlQZkiVI59b", "AT7ca5j6uH8ZMFY8gdhWcohA"};
    public final /* synthetic */ FO A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] - i3) - 52);
            String[] strArr = A02;
            if (strArr[4].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[7] = "b4q8hXeVYJWgCCKNMDRDzuby";
            strArr2[1] = "dEe326h";
            copyOfRange[i4] = b;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.SYN, Ascii.US, Ascii.NAK, Ascii.DC4, Ascii.DC2, 35, Ascii.NAK, 36};
    }

    static {
        A01();
    }

    public ViewOnClickListenerC1795eY(FO fo) {
        this.A00 = fo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr;
        ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr2;
        if (WU.A02(this)) {
            return;
        }
        try {
            viewOnClickListenerC1127Kr = this.A00.A06;
            if (viewOnClickListenerC1127Kr != null) {
                viewOnClickListenerC1127Kr2 = this.A00.A06;
                viewOnClickListenerC1127Kr2.A0E(A00(0, 8, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE));
            }
        } catch (Throwable th) {
            WU.A00(th, this);
            String[] strArr = A02;
            if (strArr[4].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            A02[6] = "NoOvb1ER3rIaV6vkspGGWoVzXAP3qQ3Z";
        }
    }
}
