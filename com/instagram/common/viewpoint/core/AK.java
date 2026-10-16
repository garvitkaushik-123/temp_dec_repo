package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@MetaExoPlayerCustomization("non-final in Fb vs final in Exo since TigonDataSource uses FailoverStreamDryException that extends this exception")
/* loaded from: assets/audience_network/classes2.dex */
public class AK extends C2415p5 {
    public static byte[] A04;
    public final int A00;
    public final String A01;
    public final Map<String, List<String>> A02;
    public final byte[] A03;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 101);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{Ascii.DLE, 39, 49, 50, 45, 44, 49, 39, 98, 33, 45, 38, 39, 120, 98};
    }

    public AK(int i, String str, IOException iOException, Map<String, List<String>> map, C07495i c07495i, byte[] bArr) {
        super(A01(0, 15, 39) + i, iOException, c07495i, 2004, 1);
        this.A00 = i;
        this.A01 = str;
        this.A02 = map;
        this.A03 = bArr;
    }
}
