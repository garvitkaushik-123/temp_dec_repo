package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class bf extends kb implements com.bytedance.sdk.component.adexpress.dynamic.Os {
    private int DbA;
    private int Xb;
    private int[] eli;

    public bf(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kb, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        super.FC();
        ((TextView) this.Dfc).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    public void MGA() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.kb, this.wC);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.Dfc).getText())) {
            setMeasuredDimension(0, this.wC);
        } else {
            setMeasuredDimension(this.kb, this.wC);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os
    public void eli(CharSequence charSequence, boolean z, int i, boolean z2) {
        String eli = com.bytedance.sdk.component.utils.ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_screen_skip_tx");
        if (i == 0) {
            this.Dfc.setVisibility(0);
            ((TextView) this.Dfc).setText("| ".concat(String.valueOf(eli)));
            this.Dfc.measure(-2, -2);
            this.eli = new int[]{this.Dfc.getMeasuredWidth() + 1, this.Dfc.getMeasuredHeight()};
            View view = this.Dfc;
            int[] iArr = this.eli;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.Dfc).setGravity(17);
            ((TextView) this.Dfc).setIncludeFontPadding(false);
            eli();
            this.Dfc.setPadding(this.nlS.Os(), this.DbA, this.nlS.aGH(), this.Xb);
        }
        requestLayout();
    }

    private void eli() {
        int eli = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.ui());
        this.DbA = ((this.wC - eli) / 2) - this.nlS.eli();
        this.Xb = 0;
    }
}
