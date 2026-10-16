package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.8t, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08368t extends Exception {
    public static byte[] A03;
    public final int A00;
    public final C2489qI A01;
    public final boolean A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 65);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{60, Byte.MAX_VALUE, 119, 45, 58, 60, 48, 41, 58, 45, 62, Base64.padSymbol, 51, 58, 118, 123, 126, 114, 60, 39, 63, Ascii.GS, 52, 19, 39, 54, 59, Base64.padSymbol, 6, 32, 51, 49, 57, 19, 62, 62, Base64.padSymbol, 49, 51, 38, 55, 54, 111, 42, 38, 86, 98, 115, 126, 120, 67, 101, 118, 116, 124, 55, 126, 121, 126, 99, 55, 113, 118, 126, 123, 114, 115, 55, 44, 0, 1, 9, 6, 8, 71};
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @MetaExoPlayerCustomization(type = {"NEW_CLASS"}, value = "D23918943: Monitor the audio track usage")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C08368t(int i, int i2, int i3, int i4, C2489qI c2489qI, boolean z, Exception exc, int i5) {
        super(r4.append(r1).append(i3).append(r1).append(i4).append(A00(15, 28, 19)).append(i5).append(r3).append(c2489qI).append(z ? A00(1, 14, 30) : A00(0, 0, 74)).toString(), exc);
        StringBuilder append = new StringBuilder().append(A00(45, 23, 86)).append(i);
        String A00 = A00(0, 1, 93);
        StringBuilder append2 = append.append(A00).append(A00(68, 7, 46)).append(i2);
        String A002 = A00(43, 2, 71);
        this.A00 = i;
        this.A02 = z;
        this.A01 = c2489qI;
    }
}
