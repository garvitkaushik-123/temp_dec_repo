package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdListener;

/* renamed from: com.facebook.ads.redexgen.X.hO, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1971hO extends WP {
    public static String[] A01 = {"12g74Y80MldwuLH5Sc5BNMhqIci3y3n7", "gYGMtvDgCappq8Eqx1aX2vuQToh52UHd", "GlXHohOtVJhIOcbHhrFcSUyeAoJlZUN4", "CknPoCaYYZqOx1VHoQWkocTpfCeiqOL0", "IgiYYUSARpIlAyCBMTexeC9bH0PhGiJU", "Cia0Frm0699G8jcollxZnIfMYARIEex0", "Mzdi9MK983UUFZlepuPfFCQdgw1DK7MX", "jSW62lJNNGtUKopGO2HTdr7H5wR53AmM"};
    public final /* synthetic */ C1969hM A00;

    public C1971hO(C1969hM c1969hM) {
        this.A00 = c1969hM;
    }

    @Override // com.instagram.common.viewpoint.core.WP
    public final void A01() {
        C1290Rd c1290Rd;
        C1290Rd c1290Rd2;
        C1290Rd c1290Rd3;
        c1290Rd = this.A00.A01;
        if (c1290Rd.A06() != null) {
            c1290Rd2 = this.A00.A01;
            String[] strArr = A01;
            if (strArr[3].charAt(29) == strArr[0].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "nnCrEA10h1A2hd08C5n1xIwFCKPiTwdC";
            strArr2[0] = "49SRRBhRmQihygS20ldMlh5Gkuzwxt90";
            AdListener A06 = c1290Rd2.A06();
            c1290Rd3 = this.A00.A01;
            A06.onAdClicked(c1290Rd3.A07());
        }
    }
}
