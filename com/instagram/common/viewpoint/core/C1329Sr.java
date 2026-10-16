package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Sr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1329Sr extends AbstractRunnableC1416Wc {
    public final /* synthetic */ long A00;
    public final /* synthetic */ WA A01;
    public final /* synthetic */ WD A02;
    public final /* synthetic */ String A03;

    public C1329Sr(WD wd, String str, long j, WA wa) {
        this.A02 = wd;
        this.A03 = str;
        this.A00 = j;
        this.A01 = wa;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        this.A02.A0N(this.A03, this.A00, this.A01);
    }
}
