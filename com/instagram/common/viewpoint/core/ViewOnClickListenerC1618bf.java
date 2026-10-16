package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.bf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1618bf implements View.OnClickListener {
    public final /* synthetic */ C1621bi A00;

    public ViewOnClickListenerC1618bf(C1621bi c1621bi) {
        this.A00 = c1621bi;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1620bh interfaceC1620bh;
        AbstractC1464Yb abstractC1464Yb;
        List list;
        C0966Ek c0966Ek;
        C0966Ek c0966Ek2;
        C0966Ek c0966Ek3;
        AbstractC1464Yb abstractC1464Yb2;
        if (WU.A02(this)) {
            return;
        }
        try {
            interfaceC1620bh = this.A00.A05;
            interfaceC1620bh.AEm();
            abstractC1464Yb = this.A00.A00;
            if (abstractC1464Yb != null) {
                abstractC1464Yb2 = this.A00.A00;
                YB.A0L(abstractC1464Yb2);
            }
            list = this.A00.A07;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                YB.A0O((View) it.next(), 0);
            }
            YB.A0J(this.A00);
            c0966Ek = this.A00.A06;
            if (c0966Ek == null) {
                return;
            }
            c0966Ek2 = this.A00.A06;
            YB.A0O(c0966Ek2, 0);
            c0966Ek3 = this.A00.A06;
            c0966Ek3.A0e(EnumC1816et.A02, 14);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
