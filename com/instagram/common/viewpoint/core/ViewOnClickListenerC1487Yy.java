package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Yy, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1487Yy implements View.OnClickListener {
    public static String[] A01 = {"F6joGwlDI8iHbOzAisWUuE", "maTihVjplMt3yFJVJjmC0KmpbmehhX2e", "XpTxCcWpZPP2y4C0a9j2n0d0MxBWLTpI", "sgfvA1KSqWI8KtEvB6m8ZyDvc5DWsN6n", "pzMBgxyxqMiPYS0J7CYt5msvRsH6xIdq", "11mnBsf4lSYjVT8AEBIdPT", "UMn24MW5IHqIwX55a9EJeoGY4QyDeK8V", "me7LrSnqK6vn3rCyE1y3nY3eC8Lw1mdr"};
    public final /* synthetic */ C07736g A00;

    public ViewOnClickListenerC1487Yy(C07736g c07736g) {
        this.A00 = c07736g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewOnClickListenerC0936Dg viewOnClickListenerC0936Dg;
        if (WU.A02(this)) {
            return;
        }
        try {
            viewOnClickListenerC0936Dg = this.A00.A0A;
            viewOnClickListenerC0936Dg.onClick(view);
        } catch (Throwable th) {
            WU.A00(th, this);
            if (A01[3].charAt(5) != '1') {
                throw new RuntimeException();
            }
            A01[1] = "W3cGemgA1Z9oaIj4IYerUOiD4w2U2gjw";
        }
    }
}
