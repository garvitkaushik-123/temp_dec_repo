package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.5l, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract /* synthetic */ class AbstractC07525l {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_CONCURRENT_STREAM_LIMIT);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{52, SignedBytes.MAX_POWER_OF_TWO, 57, 56, 69, 54, 73, 69, 43, Ascii.FS, 47, 43, -26, 45, 43, 43, 32, Ascii.NAK, Ascii.DC4};
    }

    public static /* synthetic */ boolean A02(String str) {
        if (str == null) {
            return false;
        }
        String A01 = AbstractC2124k7.A01(str);
        if (TextUtils.isEmpty(A01)) {
            return false;
        }
        return ((A01.contains(A00(4, 4, 105)) && !A01.contains(A00(8, 8, 79))) || A01.contains(A00(0, 4, 100)) || A01.contains(A00(16, 3, 64))) ? false : true;
    }
}
