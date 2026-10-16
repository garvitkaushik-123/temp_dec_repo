package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class aGH extends dV<com.bytedance.sdk.component.adexpress.MGA.kb> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.dV
    protected void aGH() {
    }

    public aGH(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        super(context, uiVar, kbVar);
        eli(kbVar);
    }

    private void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        this.eli = new com.bytedance.sdk.component.adexpress.MGA.kb(this.DbA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.DbA, kbVar.tGZ());
        this.eli.setLayoutParams(layoutParams);
        this.eli.setSlideText(this.aGH.QI());
        if (this.eli instanceof com.bytedance.sdk.component.adexpress.MGA.kb) {
            ((com.bytedance.sdk.component.adexpress.MGA.kb) this.eli).setButtonText(this.aGH.aAs());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.dV, com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void eli() {
        this.eli.eli();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.dV, com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void DbA() {
        this.eli.DbA();
    }
}
