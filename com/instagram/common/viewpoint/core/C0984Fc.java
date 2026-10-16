package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Fc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0984Fc extends AbstractC1873fo {
    public final /* synthetic */ VA A00;
    public final /* synthetic */ Y2 A01;
    public final /* synthetic */ C1767e5 A02;
    public final /* synthetic */ FY A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public C0984Fc(FY fy, String str, C1767e5 c1767e5, VA va, Map map, Y2 y2) {
        this.A03 = fy;
        this.A04 = str;
        this.A02 = c1767e5;
        this.A00 = va;
        this.A05 = map;
        this.A01 = y2;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1873fo
    public final void A03() {
        C1874fp c1874fp;
        SparseBooleanArray sparseBooleanArray;
        C1874fp c1874fp2;
        C1193Ng c1193Ng;
        C1929gi c1929gi;
        SparseBooleanArray sparseBooleanArray2;
        c1874fp = this.A03.A02;
        if (!c1874fp.A0Z() && !TextUtils.isEmpty(this.A04)) {
            sparseBooleanArray = this.A03.A08;
            if (!sparseBooleanArray.get(this.A02.A02())) {
                VA va = this.A00;
                String str = this.A04;
                C1586b9 c1586b9 = new C1586b9(this.A05);
                c1874fp2 = this.A03.A03;
                va.ABJ(str, c1586b9.A03(c1874fp2).A02(this.A01).A05());
                c1193Ng = this.A03.A00;
                c1929gi = this.A03.A09;
                C1193Ng.A07(c1193Ng, c1929gi);
                sparseBooleanArray2 = this.A03.A08;
                sparseBooleanArray2.put(this.A02.A02(), true);
            }
        }
    }
}
