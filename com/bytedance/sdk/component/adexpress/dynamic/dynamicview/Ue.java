package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Ue extends MGA implements com.bytedance.sdk.component.adexpress.dynamic.Os {
    private boolean CMM;
    boolean DbA;
    private int Xb;
    private int bf;
    int eli;

    public Ue(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.bf = 0;
        setTag(Integer.valueOf(getClickArea()));
        eli();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().ujq()) {
            return;
        }
        if (this.Dfc != null) {
            this.Dfc.setVisibility(8);
        }
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    public void MGA() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.DbA) {
            layoutParams.leftMargin = this.FC;
        } else {
            layoutParams.leftMargin = this.FC + this.bf;
        }
        if (this.CMM && this.nlS != null) {
            layoutParams.leftMargin = ((this.FC + this.bf) - ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.Os()))) - ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.aGH()));
        }
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            layoutParams.topMargin = this.aAs - ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.DbA()));
        } else {
            layoutParams.topMargin = this.aAs;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        if (com.bytedance.sdk.component.adexpress.aGH.MGA.DbA(this.nn.getRenderRequest().aGH())) {
            return true;
        }
        super.FC();
        setPadding((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.Os()), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.DbA()), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.aGH()), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.eli()));
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.CMM && this.nlS != null) {
            setMeasuredDimension(this.Xb + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.Os())) + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.aGH())), this.wC);
        } else if (this.DbA) {
            setMeasuredDimension(this.kb, this.wC);
        } else {
            setMeasuredDimension(this.eli, this.wC);
        }
    }

    private void eli() {
        List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> du = this.NU.du();
        if (du == null || du.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it = du.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.aGH.wC next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.aAs().DbA())) {
                this.Xb = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, next.wC() + (com.bytedance.sdk.component.adexpress.aGH.DbA() ? next.NU() : 0));
                this.eli = this.kb - this.Xb;
            }
        }
        this.bf = this.kb - this.eli;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os
    public void eli(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.CMM != z2) {
            this.CMM = z2;
            MGA();
            return;
        }
        if (z && this.DbA != z) {
            this.DbA = z;
            MGA();
        }
        this.DbA = z;
    }
}
