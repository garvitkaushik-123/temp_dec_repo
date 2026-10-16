package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.lN, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2199lN implements InterfaceC1131Kv {
    public static byte[] A06;
    public int A00;
    public int A01;
    public long A02 = -9223372036854775807L;
    public boolean A03;
    public final List<LC> A04;
    public final InterfaceC1036Hd[] A05;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 49);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{1, Ascii.DLE, Ascii.DLE, Ascii.FF, 9, 3, 1, Ascii.DC4, 9, Ascii.SI, Ascii.SO, -49, 4, Ascii.SYN, 2, 19, Ascii.NAK, 2, 19};
    }

    public C2199lN(List<LC> list) {
        this.A04 = list;
        this.A05 = new InterfaceC1036Hd[list.size()];
    }

    private boolean A02(C07364v c07364v, int i) {
        if (c07364v.A07() == 0) {
            return false;
        }
        if (c07364v.A0I() != i) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5A(C07364v c07364v) {
        if (this.A03) {
            if (this.A00 == 2 && !A02(c07364v, 32)) {
                return;
            }
            if (this.A00 == 1 && !A02(c07364v, 0)) {
                return;
            }
            int A09 = c07364v.A09();
            int A07 = c07364v.A07();
            for (InterfaceC1036Hd interfaceC1036Hd : this.A05) {
                c07364v.A0f(A09);
                interfaceC1036Hd.AIr(c07364v, A07);
            }
            int dataPosition = this.A01;
            this.A01 = dataPosition + A07;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0004 */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A5c(HA ha, LG lg) {
        for (int i = 0; i < i; i++) {
            LC lc = this.A04.get(i);
            lg.A05();
            InterfaceC1036Hd AKS = ha.AKS(lg.A03(), 3);
            AKS.A6e(new C06802p().A0y(lg.A04()).A11(A00(0, 19, 111)).A12(Collections.singletonList(lc.A02)).A10(lc.A01).A14());
            this.A05[i] = AKS;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGp() {
        if (this.A03) {
            if (this.A02 != -9223372036854775807L) {
                for (InterfaceC1036Hd interfaceC1036Hd : this.A05) {
                    interfaceC1036Hd.AIu(this.A02, 1, this.A01, 0, null);
                }
            }
            this.A03 = false;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGq(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.A03 = true;
        if (j != -9223372036854775807L) {
            this.A02 = j;
        }
        this.A01 = 0;
        this.A00 = 2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AJ5() {
        this.A03 = false;
        this.A02 = -9223372036854775807L;
    }
}
