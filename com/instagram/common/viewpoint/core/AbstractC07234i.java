package com.instagram.common.viewpoint.core;

import android.media.MediaFormat;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.4i, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC07234i {
    public static byte[] A00;
    public static String[] A01 = {"xemy17oJESjX", "rPO8UlQzVoplqsv241x2vKH9ITvvG5RO", "lwnNPX4PInl", "3ZJzEwR8uVRMBQC0tqntIJ86zVyjP6", "EDwbiEJ5SEYx8yR18WYzWyNJdlpGFaeE", "Kr1YCqNPaz9XeY6", "vkRdwAWmOCKEbB6zjyqD0a8RWRR8tEwK", "9fnayNKVpPH2aeCe0iQJlqHqzIFqpYut"};

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 112);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {74, 86, 83, 86, 89, Ascii.DC4, 89, 72, 85, 78, 76, Ascii.VT, Ascii.ETB, Ascii.DC4, Ascii.ETB, Ascii.SUB, -43, Ascii.ESC, Ascii.FS, 9, Ascii.SYN, Ascii.FF, 9, Ascii.SUB, Ascii.FF, -22, -10, -13, -10, -7, -76, -5, -7, -24, -11, -6, -19, -20, -7, -29, -13, -28, -83, 85, 81, 95, Ascii.SUB, 96, 97, 78, 97, 86, 80, Ascii.SUB, 86, 91, 83, 92};
        if (A01[1].charAt(12) != 'q') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "2QjkwbE64yFQhHjtiWmGMRmbrZEFKpMO";
        strArr[0] = "Fg5M50njpCut";
        A00 = bArr;
    }

    static {
        A01();
    }

    public static void A02(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo != null) {
            A04(mediaFormat, A00(25, 14, 23), colorInfo.A03);
            A04(mediaFormat, A00(11, 14, 56), colorInfo.A02);
            A04(mediaFormat, A00(0, 11, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), colorInfo.A01);
            A05(mediaFormat, A00(43, 15, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), colorInfo.A04);
        }
    }

    public static void A03(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void A04(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void A05(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A06(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < i; i++) {
            mediaFormat.setByteBuffer(A00(39, 4, 16) + i, ByteBuffer.wrap(list.get(i)));
        }
    }
}
