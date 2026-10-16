package com.instagram.common.viewpoint.core;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: com.facebook.ads.redexgen.X.lK, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2196lK implements InterfaceC1131Kv {
    public static byte[] A0F;
    public static String[] A0G = {"mAIJKcC20Y3eOfYyWQRzrg7mLeRMrJFl", "eZxkBrFzPoxgu8goyyke6z3uoIiInH7I", "", "7SF2NgL0Q5eCPREDvftOSH9OstPB", "tBtJ4FuF4UkjOIbBZeVQSFTGpUKvKhYU", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "JQCW8upC74KuI6xTj5WGF", "PsTmzjLTY6QrmqAE1gFrtVK8jOOfhc8D"};
    public long A01;
    public InterfaceC1036Hd A02;
    public L2 A03;
    public String A04;
    public boolean A05;
    public boolean A06;
    public final L9 A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean[] A0E = new boolean[3];
    public final L4 A0A = new L4(7, 128);
    public final L4 A08 = new L4(8, 128);
    public final L4 A09 = new L4(6, 128);
    public long A00 = -9223372036854775807L;
    public final C07364v A07 = new C07364v();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 62);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0F = new byte[]{60, 35, 46, 47, 37, 101, 43, 60, 41};
    }

    static {
        A02();
    }

    public C2196lK(L9 l9, boolean z, boolean z2) {
        this.A0B = l9;
        this.A0C = z;
        this.A0D = z2;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void A01() {
        AbstractC07133y.A02(this.A02);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void A03(long j, int i, int i2, long j2) {
        if (!this.A05 || this.A03.A06()) {
            this.A0A.A04(i2);
            this.A08.A04(i2);
            if (!this.A05) {
                if (this.A0A.A03() && this.A08.A03()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.A0A.A01, this.A0A.A00));
                    arrayList.add(Arrays.copyOf(this.A08.A01, this.A08.A00));
                    HR A09 = HS.A09(this.A0A.A01, 3, this.A0A.A00);
                    HQ A07 = HS.A07(this.A08.A01, 3, this.A08.A00);
                    this.A02.A6e(new C06802p().A0y(this.A04).A11(A00(0, 9, 116)).A0w(AnonymousClass46.A01(A09.A08, A09.A01, A09.A04)).A0r(A09.A0A).A0f(A09.A03).A0Y(A09.A00).A12(arrayList).A14());
                    this.A05 = true;
                    this.A03.A04(A09);
                    this.A03.A03(A07);
                    this.A0A.A00();
                    this.A08.A00();
                }
            } else {
                boolean sampleIsKeyFrame = this.A0A.A03();
                if (sampleIsKeyFrame) {
                    this.A03.A04(HS.A09(this.A0A.A01, 3, this.A0A.A00));
                    this.A0A.A00();
                } else if (this.A08.A03()) {
                    this.A03.A03(HS.A07(this.A08.A01, 3, this.A08.A00));
                    this.A08.A00();
                }
            }
        }
        if (this.A09.A04(i2)) {
            byte[] bArr = this.A09.A01;
            if (A0G[7].charAt(24) == 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[6] = "IcPmfl1yBNDnokE5CaufU";
            strArr[2] = "";
            this.A07.A0j(this.A09.A01, HS.A02(bArr, this.A09.A00));
            this.A07.A0f(4);
            this.A0B.A02(j2, this.A07);
        }
        boolean sampleIsKeyFrame2 = this.A03.A07(j, i, this.A05, this.A06);
        if (sampleIsKeyFrame2) {
            this.A06 = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void A04(long j, int i, long j2) {
        if (!this.A05 || this.A03.A06()) {
            this.A0A.A01(i);
            this.A08.A01(i);
        }
        this.A09.A01(i);
        this.A03.A02(j, i, j2);
    }

    @RequiresNonNull({"sampleReader"})
    private void A05(byte[] bArr, int i, int i2) {
        if (!this.A05 || this.A03.A06()) {
            this.A0A.A02(bArr, i, i2);
            this.A08.A02(bArr, i, i2);
        }
        this.A09.A02(bArr, i, i2);
        this.A03.A05(bArr, i, i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5A(C07364v c07364v) {
        A01();
        int A09 = c07364v.A09();
        int A0A = c07364v.A0A();
        byte[] A0l = c07364v.A0l();
        long j = this.A01;
        int offset = c07364v.A07();
        this.A01 = j + offset;
        InterfaceC1036Hd interfaceC1036Hd = this.A02;
        int offset2 = c07364v.A07();
        interfaceC1036Hd.AIr(c07364v, offset2);
        while (true) {
            int A04 = HS.A04(A0l, A09, A0A, this.A0E);
            if (A04 == A0A) {
                A05(A0l, A09, A0A);
                return;
            }
            int lengthToNalUnit = HS.A01(A0l, A04);
            if (A0G[7].charAt(24) == 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[6] = "800XsA7BA4hpamNrxbWO1";
            strArr[2] = "";
            int i = A04 - A09;
            if (i > 0) {
                A05(A0l, A09, A04);
            }
            int i2 = A0A - A04;
            long j2 = this.A01 - i2;
            int offset3 = i < 0 ? -i : 0;
            A03(j2, i2, offset3, this.A00);
            A04(j2, lengthToNalUnit, this.A00);
            A09 = A04 + 3;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A04 = lg.A04();
        this.A02 = ha.AKS(lg.A03(), 2);
        this.A03 = new L2(this.A02, this.A0C, this.A0D);
        this.A0B.A03(ha, lg);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGp() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGq(long j, int i) {
        if (j != -9223372036854775807L) {
            this.A00 = j;
        }
        this.A06 |= (i & 2) != 0;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AJ5() {
        this.A01 = 0L;
        this.A06 = false;
        this.A00 = -9223372036854775807L;
        HS.A0H(this.A0E);
        this.A0A.A00();
        this.A08.A00();
        this.A09.A00();
        if (this.A03 != null) {
            this.A03.A01();
        }
    }
}
