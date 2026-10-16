package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.MGA.CMM;

/* loaded from: classes3.dex */
public class dV<E extends CMM> implements kb<E> {
    protected Context DbA;
    protected com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui Os;
    protected com.bytedance.sdk.component.adexpress.dynamic.aGH.kb aGH;
    protected CMM eli;
    protected int ui;

    public dV(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar, int i) {
        this.ui = i;
        this.DbA = context;
        this.Os = uiVar;
        this.aGH = kbVar;
        aGH();
    }

    public dV(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        this(context, uiVar, kbVar, 0);
    }

    protected void aGH() {
        this.eli = new CMM(this.DbA, this.aGH.FS());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.DbA, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.DbA, 100 - this.ui);
        this.eli.setLayoutParams(layoutParams);
        try {
            this.eli.setGuideText(this.aGH.QI());
        } catch (Throwable unused) {
        }
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
    /* renamed from: ui, reason: merged with bridge method [inline-methods] */
    public E Os() {
        return (E) this.eli;
    }
}
