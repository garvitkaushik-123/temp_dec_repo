package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* renamed from: com.facebook.ads.redexgen.X.lv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2233lv extends AbstractC1085Jb {
    public static byte[] A01;
    public static String[] A02 = {"llfHvvp5w7AsdcfCf5e", "amqCmPcUyTwYr5NdTloeCtiw", "0NAIhycYLxj75", "dj34azdkZPKXRKaV6TbpL4Sg", "ijcAEj6S85lKiCQyoflHjypUMqTEGqRn", "eY0hdp8", "jqGnWXF3Z8AkxtecEpgwxV1mUEmkJWKs", "4zwbE0EN4gXO5y3Vp0p"};
    public static final byte[] A03;
    public static final byte[] A04;
    public boolean A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 125);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-1, 19, 2, 7, Ascii.CR, -51, Ascii.CR, Ascii.SO, 19, 17};
    }

    static {
        A01();
        A04 = new byte[]{79, 112, 117, 115, 72, 101, 97, 100};
        A03 = new byte[]{79, 112, 117, 115, 84, 97, 103, 115};
    }

    public static boolean A02(C07364v c07364v) {
        return A03(c07364v, A04);
    }

    public static boolean A03(C07364v c07364v, byte[] bArr) {
        if (c07364v.A07() < bArr.length) {
            return false;
        }
        int A09 = c07364v.A09();
        int startPosition = bArr.length;
        byte[] header = new byte[startPosition];
        int startPosition2 = bArr.length;
        c07364v.A0k(header, 0, startPosition2);
        c07364v.A0f(A09);
        return Arrays.equals(header, bArr);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1085Jb
    public final long A09(C07364v c07364v) {
        return A06(HT.A05(c07364v.A0l()));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1085Jb
    public final void A0B(boolean z) {
        super.A0B(z);
        if (z) {
            this.A00 = false;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1085Jb
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    @MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    public final boolean A0C(C07364v c07364v, long j, C1084Ja c1084Ja) throws C3K {
        if (A03(c07364v, A04)) {
            byte[] headerBytes = Arrays.copyOf(c07364v.A0l(), c07364v.A0A());
            int A012 = HT.A01(headerBytes);
            List<byte[]> A06 = HT.A06(headerBytes);
            if (c1084Ja.A00 != null) {
                return true;
            }
            c1084Ja.A00 = new C06802p().A11(A00(0, 10, 33)).A0b(A012).A0m(48000).A12(A06).A14();
            return true;
        }
        if (A03(c07364v, A03)) {
            AbstractC07133y.A02(c1084Ja.A00);
            if (this.A00) {
                return true;
            }
            this.A00 = true;
            c07364v.A0g(A03.length);
            C1040Hh commentHeader = AbstractC1043Hk.A05(c07364v, false, false);
            Metadata A022 = AbstractC1043Hk.A02(MetaExoPlayerCustomizedCollections.A02(commentHeader.A02));
            if (A022 == null) {
                return true;
            }
            C06802p A07 = c1084Ja.A00.A07();
            String[] strArr = A02;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "80vtnZ0VGuLh5BtNytGnkcmL";
            strArr2[1] = "kfnMkjsOg47yHVBMKsSTRfGb";
            c1084Ja.A00 = A07.A0v(A022.A04(c1084Ja.A00.A0P)).A14();
            return true;
        }
        AbstractC07133y.A02(c1084Ja.A00);
        return false;
    }
}
