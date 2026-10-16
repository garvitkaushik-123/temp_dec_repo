package com.instagram.common.viewpoint.core;

import android.media.MediaFormat;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.Random;

/* renamed from: com.facebook.ads.redexgen.X.is, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2056is {
    public static String A00;
    public static String A01;
    public static byte[] A02;
    public static final Random A03;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{39, 0, 8, Ascii.CR, 4, 5, 65, Ascii.NAK, Ascii.SO, 65, 19, 4, Ascii.NAK, 19, 8, 4, Ascii.ETB, 4, 65, 44, 4, 5, 8, 0, 39, Ascii.SO, 19, Ascii.FF, 0, Ascii.NAK, 73, 100, 115, 110, 68, 121, 110, 84, 117, 104, 109, 9, 43, 54, 33, 32, 116, 10, 45, 56, 45, 44, 42, 126, 72, 89, Ascii.CR, 108, 100, Ascii.CR, 107, Byte.MAX_VALUE, 110, Ascii.CR, 124, 107, 105, Ascii.CR, 65, 72, 91, 72, 65, Ascii.CR, 89, 66, Ascii.CR, 8, 73, 59, Ascii.CR, Ascii.FS, 72, 41, 33, 72, 46, 58, 43, 72, Ascii.SUB, Ascii.CR, Ascii.EM, Ascii.GS, Ascii.CR, Ascii.ESC, Ascii.FS, 72, Ascii.FS, 7, 72, 89, Ascii.FF, 58, 43, Byte.MAX_VALUE, Ascii.RS, Ascii.SYN, Byte.MAX_VALUE, Ascii.EM, Ascii.CR, Ascii.FS, Byte.MAX_VALUE, 41, 54, 59, 58, 48, Byte.MAX_VALUE, 59, 42, 45, 62, 43, 54, 48, 49, Byte.MAX_VALUE, 43, 48, Byte.MAX_VALUE, 122, 59, 37, 40, 36, 42, 37, 57, 19, Ascii.SO, 10, 2, 8, Ascii.DC2, 19, 56, 19, Ascii.NAK, Ascii.RS, Ascii.SO, 9, 0, 56, 19, 8, 56, 1, Ascii.SO, 9, 3, 56, Ascii.DC4, 2, 0, 10, 2, 9, 19, 56, Ascii.SO, 9, 56, 8, Ascii.SO, Ascii.VT, Ascii.SI, Ascii.FS, Ascii.ETB, Ascii.GS, Ascii.SYN, Ascii.VT, 87, 10, Ascii.FS, Ascii.SUB, 84, Ascii.CAN, Ascii.DLE, Ascii.US, Ascii.VT, Ascii.SUB, 84, Ascii.CR, Ascii.VT, Ascii.CAN, Ascii.ETB, 10, Ascii.US, Ascii.FS, Ascii.VT, 84, Ascii.VT, Ascii.FS, 8, Ascii.FF, Ascii.FS, 10, Ascii.CR, 87, Ascii.SI, Ascii.CAN, Ascii.NAK, Ascii.FF, Ascii.FS, 112, 99, 104, 98, 105, 116, 40, 117, 99, 101, 43, 103, 111, 96, 116, 101, 43, 112, 111, 98, 99, 105, 43, 98, 115, 116, 103, 114, 111, 105, 104, 40, 112, 103, 106, 115, 99, 78, 93, 86, 92, 87, 74, Ascii.SYN, 75, 93, 91, Ascii.NAK, 89, 81, 94, 74, 91, Ascii.NAK, 78, 81, 92, 93, 87, Ascii.NAK, 73, 94, 92, Ascii.NAK, 84, 93, 78, 93, 84, Ascii.SYN, 78, 89, 84, 77, 93, 89, 71, 74, 90, 70};
    }

    static {
        A02();
        A00 = A01(41, 12, 83);
        A01 = A01(TsExtractor.TS_STREAM_TYPE_DTS_UHD, 37, 109);
        A03 = new Random();
    }

    public static int A00(int i, int i2) {
        if (i2 != 0) {
            return (int) ((Math.pow(2.0d, i - 1) * i2 * 1000.0d) + A03.nextInt(2000));
        }
        return (int) Math.min(((i - 1) * 1000) + 500, 5000L);
    }

    public static void A03(C2085jQ c2085jQ, MediaFormat mediaFormat) {
        String A012 = A01(0, 30, 107);
        String A013 = A01(30, 11, 11);
        if (!c2085jQ.A01) {
            return;
        }
        try {
            if (C2054iq.A02()) {
                if (c2085jQ.A0P && !C2054iq.A03(mediaFormat.getInteger(A01(290, 5, 36)), mediaFormat.getInteger(A01(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 6, 71)))) {
                    return;
                }
                long j = c2085jQ.A00;
                if (j > 0) {
                    mediaFormat.setLong(A01(Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE, 37, 12), j);
                    AbstractC1986hd.A01(A013, A01(102, 31, 85), Long.valueOf(j));
                }
                mediaFormat.setInteger(A01(252, 38, 50), c2085jQ.A02);
                AbstractC1986hd.A01(A013, A01(53, 26, 39), Integer.valueOf(c2085jQ.A02));
                mediaFormat.setInteger(A01(176, 39, 115), 1);
                AbstractC1986hd.A00(A013, A01(79, 23, 98));
            }
        } catch (ClassCastException e) {
            AbstractC1986hd.A02(A013, A012, e);
        } catch (NullPointerException e2) {
            AbstractC1986hd.A02(A013, A012, e2);
        }
    }

    public static boolean A04(C2085jQ c2085jQ, int i, int i2, int i3, int i4) {
        if (c2085jQ.A01 && c2085jQ.A0P && C2054iq.A03(i, i2) != C2054iq.A03(i3, i4)) {
            return true;
        }
        return false;
    }
}
