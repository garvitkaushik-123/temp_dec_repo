package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class nGm implements kb<com.bytedance.sdk.component.adexpress.MGA.du> {
    private final com.bytedance.sdk.component.adexpress.MGA.du eli;

    public nGm(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        int i;
        com.bytedance.sdk.component.adexpress.MGA.du duVar = new com.bytedance.sdk.component.adexpress.MGA.du(context);
        this.eli = duVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (kbVar.tGZ() > 0) {
            i = kbVar.tGZ();
        } else {
            i = com.bytedance.sdk.component.adexpress.aGH.DbA() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, i);
        duVar.setLayoutParams(layoutParams);
        duVar.setClipChildren(false);
        duVar.setText(kbVar.QI());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void eli() {
        com.bytedance.sdk.component.adexpress.MGA.du duVar = this.eli;
        if (duVar != null) {
            duVar.eli();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void DbA() {
        com.bytedance.sdk.component.adexpress.MGA.du duVar = this.eli;
        if (duVar != null) {
            duVar.DbA();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.MGA.du Os() {
        return this.eli;
    }
}
