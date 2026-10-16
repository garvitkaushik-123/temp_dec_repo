package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.List;

/* loaded from: classes3.dex */
public class CMM extends MGA implements com.bytedance.sdk.component.adexpress.dynamic.Os {
    private int DbA;
    private int Xb;
    private int eli;

    public CMM(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        eli();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.Os()), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.DbA()), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.aGH()), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.eli()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    public void MGA() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.FC;
        layoutParams.topMargin = this.aAs;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Xb == 0) {
            setMeasuredDimension(this.DbA, this.wC);
        } else {
            setMeasuredDimension(this.eli, this.wC);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os
    public void eli(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.Xb = i;
    }

    private void eli() {
        List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> du = this.NU.du();
        if (du == null || du.size() <= 0) {
            return;
        }
        for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar : du) {
            if (wCVar.aAs().eli() == 21) {
                this.eli = (int) (this.kb - com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, wCVar.wC()));
            }
            if (wCVar.aAs().eli() == 20) {
                this.DbA = (int) (this.kb - com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, wCVar.wC()));
            }
        }
    }
}
