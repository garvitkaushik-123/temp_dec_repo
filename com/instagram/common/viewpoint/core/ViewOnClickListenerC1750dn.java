package com.instagram.common.viewpoint.core;

import android.view.View;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.dn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1750dn implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C07384x A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{39, 42, 46, 43, 42, Base64.padSymbol};
    }

    public ViewOnClickListenerC1750dn(C07384x c07384x) {
        this.A00 = c07384x;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AbstractC1642c3 abstractC1642c3;
        AbstractC1642c3 abstractC1642c32;
        if (WU.A02(this)) {
            return;
        }
        try {
            abstractC1642c3 = this.A00.A00;
            if (abstractC1642c3 != null) {
                abstractC1642c32 = this.A00.A00;
                abstractC1642c32.A1B(A00(0, 6, 53));
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
