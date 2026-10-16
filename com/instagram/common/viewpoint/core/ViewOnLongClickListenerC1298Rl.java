package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Rl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnLongClickListenerC1298Rl implements View.OnLongClickListener {
    public final /* synthetic */ C1969hM A00;
    public final /* synthetic */ C1583b6 A01;

    public ViewOnLongClickListenerC1298Rl(C1969hM c1969hM, C1583b6 c1583b6) {
        this.A00 = c1969hM;
        this.A01 = c1583b6;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        View view2;
        View view3;
        View view4;
        view2 = this.A00.A00;
        if (view2 != null) {
            C1583b6 c1583b6 = this.A01;
            view3 = this.A00.A00;
            int width = view3.getWidth();
            view4 = this.A00.A00;
            c1583b6.setBounds(0, 0, width, view4.getHeight());
            this.A01.A0D(!this.A01.A0E());
        }
        return true;
    }
}
