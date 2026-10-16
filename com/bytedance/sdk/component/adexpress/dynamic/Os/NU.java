package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class NU implements kb {
    private com.bytedance.sdk.component.adexpress.MGA.Dfc eli;

    public NU(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        this.eli = new com.bytedance.sdk.component.adexpress.MGA.Dfc(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(uiVar.getDynamicHeight(), uiVar.getDynamicHeight());
        layoutParams.gravity = 8388629;
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
    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.MGA.Dfc Os() {
        return this.eli;
    }
}
