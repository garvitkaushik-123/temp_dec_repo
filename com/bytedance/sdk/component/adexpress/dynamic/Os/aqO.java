package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.MGA.bf;

/* loaded from: classes3.dex */
public class aqO implements kb {
    private Context DbA;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui Os;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.kb aGH;
    private bf eli;

    public aqO(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        this.DbA = context;
        this.Os = uiVar;
        this.aGH = kbVar;
        aGH();
    }

    private void aGH() {
        this.eli = new bf(this.DbA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.DbA, 120.0f));
        layoutParams.gravity = 17;
        this.eli.setLayoutParams(layoutParams);
        this.eli.setClipChildren(false);
        this.eli.setGuideText(this.aGH.QI());
        com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar = this.Os;
        if (uiVar != null) {
            this.eli.setOnClickListener((View.OnClickListener) uiVar.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void eli() {
        bf bfVar = this.eli;
        if (bfVar != null) {
            bfVar.eli();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void DbA() {
        bf bfVar = this.eli;
        if (bfVar != null) {
            bfVar.DbA();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public ViewGroup Os() {
        return this.eli;
    }
}
