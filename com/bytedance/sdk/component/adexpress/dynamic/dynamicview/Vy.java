package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class Vy extends MGA {
    private int eli;

    public Vy(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.eli = 0;
        this.Dfc = new com.bytedance.sdk.component.adexpress.MGA.Vy(context, null);
        this.Dfc.setTag(Integer.valueOf(getClickArea()));
        addView(this.Dfc, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        int eli = (int) ((com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.ui()) * 5.0f) + com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.Os() + com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.aGH())));
        if (this.kb > eli && 4 == this.nlS.wC()) {
            this.eli = (this.kb - eli) / 2;
        }
        this.kb = eli;
        return new FrameLayout.LayoutParams(this.kb, this.wC);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    public void MGA() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.kb, this.wC);
        layoutParams.topMargin = this.aAs;
        layoutParams.leftMargin = this.FC + this.eli;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        super.FC();
        double NU = this.nlS.NU();
        if (com.bytedance.sdk.component.adexpress.aGH.DbA() && (NU < 0.0d || NU > 5.0d || (this.nn != null && this.nn.getRenderRequest() != null && this.nn.getRenderRequest().aAs() != 4))) {
            this.Dfc.setVisibility(8);
            return true;
        }
        double d = (NU < 0.0d || NU > 5.0d) ? 5.0d : NU;
        this.Dfc.setVisibility(0);
        ((com.bytedance.sdk.component.adexpress.MGA.Vy) this.Dfc).eli(d, this.nlS.kb(), (int) this.nlS.ui(), ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.DbA())) + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.eli())) + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.ui())));
        return true;
    }
}
