package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Hm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1045Hm extends AbstractRunnableC1416Wc {
    public static byte[] A02;
    public final /* synthetic */ AnonymousClass55 A00;
    public final /* synthetic */ C4A A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_SKIP_LIMIT_REACHED);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Ascii.NAK, 72, 57, 57, 56, 69, 60, 65, 58, -13, 60, 65, 55, 56, 57, 60, 65, 60, 71, 56, 63, 76};
    }

    public C1045Hm(AnonymousClass55 anonymousClass55, C4A c4a) {
        this.A00 = anonymousClass55;
        this.A01 = c4a;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        C0966Ek c0966Ek;
        C0966Ek c0966Ek2;
        c0966Ek = this.A00.A0b;
        if (c0966Ek.getState() == EnumC1871fm.A02) {
            c0966Ek2 = this.A00.A0b;
            if (c0966Ek2.getCurrentPositionInMillis() == A00()) {
                this.A00.A0s(A00(0, 22, 104));
            }
        }
    }
}
