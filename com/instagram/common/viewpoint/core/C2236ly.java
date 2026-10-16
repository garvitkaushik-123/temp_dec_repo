package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* renamed from: com.facebook.ads.redexgen.X.ly, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2236ly extends AbstractC1085Jb {
    public static String[] A02 = {"WZkrugZ9k", "x4SWtznAL", "HpTT9hwXiF", "GejxPsVIqdMqn4uNSueU2CvK5QdcE", "kY6PJZpIMUpeuimCFjYxSQzMMPc04", "AyPx1MENxNPCbM7HZGi1kOnAmMtkHxm9", "mMmHuZ9NaaUgibHMJoRcA4q0AdWca5ys", "Hii3DdXYVzyt8ReiNrO7wglp0i"};
    public HJ A00;
    public C2237lz A01;

    private int A00(C07364v c07364v) {
        int i = (c07364v.A0l()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            c07364v.A0g(4);
            String[] strArr = A02;
            String str = strArr[6];
            String str2 = strArr[5];
            int charAt = str.charAt(19);
            int blockSizeKey = str2.charAt(19);
            if (charAt == blockSizeKey) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "Cisj8wK8S";
            strArr2[0] = "koTyuZ08X";
            c07364v.A0S();
        }
        int result = HF.A00(c07364v, i);
        c07364v.A0f(0);
        return result;
    }

    public static boolean A01(C07364v c07364v) {
        return c07364v.A07() >= 5 && c07364v.A0I() == 127 && c07364v.A0Q() == 1179402563;
    }

    public static boolean A02(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1085Jb
    public final long A09(C07364v c07364v) {
        if (!A02(c07364v.A0l())) {
            return -1L;
        }
        return A00(c07364v);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1085Jb
    public final void A0B(boolean z) {
        super.A0B(z);
        if (z) {
            this.A00 = null;
            this.A01 = null;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1085Jb
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean A0C(C07364v c07364v, long j, C1084Ja c1084Ja) {
        byte[] A0l = c07364v.A0l();
        HJ hj = this.A00;
        if (hj == null) {
            HJ hj2 = new HJ(A0l, 17);
            this.A00 = hj2;
            c1084Ja.A00 = hj2.A08(Arrays.copyOfRange(A0l, 9, c07364v.A0A()), null);
            return true;
        }
        if ((A0l[0] & Byte.MAX_VALUE) == 3) {
            HI A03 = HH.A03(c07364v);
            HJ streamMetadata = hj.A09(A03);
            this.A00 = streamMetadata;
            this.A01 = new C2237lz(streamMetadata, A03);
            return true;
        }
        if (!A02(A0l)) {
            return true;
        }
        if (this.A01 != null) {
            this.A01.A00(j);
            c1084Ja.A01 = this.A01;
        }
        C2489qI c2489qI = c1084Ja.A00;
        String[] strArr = A02;
        if (strArr[4].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "zwTfeKiQLRobCpiZaAgtU0oyP8s29";
        strArr2[2] = "wrCWS6iAkk";
        AbstractC07133y.A01(c2489qI);
        return false;
    }
}
