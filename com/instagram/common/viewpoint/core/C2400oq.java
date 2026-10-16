package com.instagram.common.viewpoint.core;

import android.media.MediaFormat;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.oq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2400oq implements G2, GR, InterfaceC07957c {
    public static byte[] A04;
    public static String[] A05 = {"s2pX1dUuV9yMGkOQMpNHWy9uhNawnk9Y", "g94kU4b", "NzGTwCFJguijRpsE4vnu2khyHl2vzHxI", "mcwg2", "3H7kdFWigyqN00XNlLPoaD6s2Om", "arwBjFb", "zwCIEju4cqvLZ8D4reT2LOc82uEYQHt6", "4voNbHG588W1rePZ0VIdJriIAfqG9T"};
    public G2 A00;
    public G2 A01;
    public GR A02;
    public GR A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 1);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{2, 0, 17, 51, Ascii.FF, 1, 0, 10, 35, Ascii.ETB, 4, 8, 0, 40, 0, 17, 4, 1, 4, 17, 4, 41, Ascii.FF, Ascii.SYN, 17, 0, Ascii.VT, 0, Ascii.ETB};
    }

    static {
        A01();
    }

    public C2400oq() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC07957c
    public final void A9i(int i, Object obj) {
        switch (i) {
            case 7:
                this.A01 = (G2) obj;
                return;
            case 8:
                this.A02 = (GR) obj;
                return;
            case 10000:
                if (0 == 0) {
                    this.A00 = null;
                    this.A03 = null;
                    return;
                }
                throw new NullPointerException(A00(0, 29, 100));
            default:
                return;
        }
    }

    @Override // com.instagram.common.viewpoint.core.G2
    public final void AGS(long j, long j2, C2489qI c2489qI, MediaFormat mediaFormat) {
        if (this.A00 != null) {
            G2 g2 = this.A00;
            if (A05[0].charAt(20) != 'W') {
                throw new RuntimeException();
            }
            A05[4] = "rCzQpO90p93bI0FQ7tWj9IORt31";
            g2.AGS(j, j2, c2489qI, mediaFormat);
        }
        if (this.A01 != null) {
            this.A01.AGS(j, j2, c2489qI, mediaFormat);
        }
    }
}
