package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class DbA implements kb {
    private com.bytedance.sdk.component.adexpress.MGA.Os eli;

    public DbA(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        this.eli = new com.bytedance.sdk.component.adexpress.MGA.Os(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, 180.0f));
        layoutParams.gravity = 17;
        this.eli.setLayoutParams(layoutParams);
        this.eli.setGuideText(kbVar.QI());
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
    public com.bytedance.sdk.component.adexpress.MGA.Os Os() {
        return this.eli;
    }
}
