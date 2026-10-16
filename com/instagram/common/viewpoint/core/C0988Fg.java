package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Fg, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0988Fg extends AbstractC1873fo {
    public final /* synthetic */ C4T A00;

    public C0988Fg(C4T c4t) {
        this.A00 = c4t;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1873fo
    public final void A03() {
        Y2 y2;
        Y2 y22;
        String str;
        C1874fp c1874fp;
        Y2 y23;
        AbstractC2094jd abstractC2094jd;
        VA va;
        String str2;
        AbstractC2094jd abstractC2094jd2;
        C1929gi c1929gi;
        C1929gi c1929gi2;
        AbstractC2094jd abstractC2094jd3;
        AbstractC2094jd abstractC2094jd4;
        y2 = this.A00.A0C;
        if (!y2.A07()) {
            C4T c4t = this.A00;
            y22 = this.A00.A0C;
            c4t.setImpressionRecordingFlag(y22);
            str = this.A00.A0A;
            if (!TextUtils.isEmpty(str)) {
                C1586b9 c1586b9 = new C1586b9();
                c1874fp = this.A00.A09;
                C1586b9 A03 = c1586b9.A03(c1874fp);
                y23 = this.A00.A0C;
                C1586b9 A02 = A03.A02(y23);
                abstractC2094jd = this.A00.A0D;
                Map<String, String> A05 = A02.A04(abstractC2094jd.A0z()).A05();
                va = this.A00.A0F;
                str2 = this.A00.A0A;
                va.ABJ(str2, A05);
                abstractC2094jd2 = this.A00.A0D;
                C1193Ng A2A = abstractC2094jd2.A2A();
                c1929gi = this.A00.A0E;
                C1193Ng.A07(A2A, c1929gi);
                c1929gi2 = this.A00.A0E;
                c1929gi2.A0F().A3L();
                abstractC2094jd3 = this.A00.A03;
                String A0y = abstractC2094jd3.A0y();
                abstractC2094jd4 = this.A00.A0D;
                AbstractC1213Oa.A02(A0y, AbstractC1449Xm.A00(abstractC2094jd4.A10()));
            }
        }
    }
}
