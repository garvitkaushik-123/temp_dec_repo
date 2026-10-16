package com.instagram.common.viewpoint.core;

import android.webkit.WebView;
import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.redexgen.X.jA, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2072jA implements InterfaceC1327Sp {
    public final C1201No A00;
    public final O3 A01;
    public final C1335Sx A02;
    public final C1929gi A03;
    public final boolean A04;

    public C2072jA(C1929gi c1929gi, O3 o3, C1335Sx c1335Sx, C1201No c1201No, boolean z) {
        this.A03 = c1929gi;
        this.A01 = o3;
        this.A02 = c1335Sx;
        this.A00 = c1201No;
        this.A04 = z;
    }

    private final void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        O4 playableWebViewClient = new O4(this.A00, this.A01, this.A04);
        webView.setWebViewClient(playableWebViewClient);
        webView.loadUrl(this.A00.A0L());
        playableWebViewClient.A03();
    }

    private void A01(boolean z) {
        if (this.A00.A0G() == EnumC1202Np.A05) {
            A00();
            return;
        }
        String A0L = this.A00.A0L();
        if (z) {
            C1335Sx c1335Sx = this.A02;
            String markupUrlResult = this.A00.A0L();
            A0L = c1335Sx.A0S(markupUrlResult);
        }
        this.A00.A0T(A0L);
        this.A01.AFG();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1327Sp
    public final void ADL() {
        if (this.A04) {
            this.A01.AFF(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1327Sp
    public final void ADT() {
        A01(true);
    }
}
