package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class eli implements kb {
    private com.bytedance.sdk.component.adexpress.MGA.DbA eli;

    public eli(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        double tLO = kbVar.tLO();
        tLO = tLO == 0.0d ? 1.0d : tLO;
        double gHb = kbVar.gHb();
        int dynamicWidth = (int) (uiVar.getDynamicWidth() * 0.32d * tLO);
        int dynamicWidth2 = (int) (uiVar.getDynamicWidth() * 0.32d * (gHb != 0.0d ? gHb : 1.0d));
        this.eli = new com.bytedance.sdk.component.adexpress.MGA.DbA(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, kbVar.BH() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, kbVar.BDs() - 3);
        this.eli.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void eli() {
        this.eli.eli();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void DbA() {
        this.eli.DbA();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public ViewGroup Os() {
        return this.eli;
    }
}
