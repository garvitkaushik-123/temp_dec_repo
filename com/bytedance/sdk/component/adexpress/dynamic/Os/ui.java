package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class ui extends dV<com.bytedance.sdk.component.adexpress.MGA.kb> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.dV
    protected void aGH() {
    }

    public ui(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        super(context, uiVar, kbVar);
        eli(kbVar);
    }

    private void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        this.eli = new com.bytedance.sdk.component.adexpress.MGA.wC(this.DbA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.eli.setLayoutParams(layoutParams);
        if (this.eli instanceof com.bytedance.sdk.component.adexpress.MGA.wC) {
            ((com.bytedance.sdk.component.adexpress.MGA.wC) this.eli).setButtonText(this.aGH.QI());
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
