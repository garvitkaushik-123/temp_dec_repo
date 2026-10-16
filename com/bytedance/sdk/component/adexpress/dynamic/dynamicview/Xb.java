package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class Xb extends kb implements com.bytedance.sdk.component.adexpress.dynamic.Os {
    public Xb(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kb, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.Dfc).getText())) {
            setMeasuredDimension(0, this.wC);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    public void MGA() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.kb, this.wC);
        layoutParams.leftMargin = this.FC;
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os
    public void eli(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else {
            ((TextView) this.Dfc).setText(" | " + String.format(com.bytedance.sdk.component.utils.ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_full_skip_count_down"), Integer.valueOf(i)));
        }
        requestLayout();
    }
}
