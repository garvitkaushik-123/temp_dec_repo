package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class ujq extends kb implements com.bytedance.sdk.component.adexpress.dynamic.Os {
    private boolean DbA;
    private boolean Xb;
    private boolean eli;

    public ujq(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(wCVar.aAs().DbA())) {
            dynamicRootView.setTimedown(this.wC);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kb, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        super.FC();
        if (com.bytedance.sdk.component.adexpress.aGH.MGA.DbA(this.nn.getRenderRequest().aGH())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.NU.aAs().DbA())) {
            ((TextView) this.Dfc).setText(String.valueOf((int) Double.parseDouble(this.nlS.aAs())));
            return true;
        }
        ((TextView) this.Dfc).setText(((int) Double.parseDouble(this.nlS.aAs())) + "s");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    public void MGA() {
        if (TextUtils.equals("skip-with-countdowns-video-countdown", this.NU.aAs().DbA()) || TextUtils.equals("skip-with-time-countdown", this.NU.aAs().DbA())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.kb, this.wC);
            layoutParams.gravity = 8388627;
            if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                layoutParams.leftMargin = this.FC;
            }
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            setLayoutParams(layoutParams);
            return;
        }
        super.MGA();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.Dfc).getText())) {
            setMeasuredDimension(0, this.wC);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os
    public void eli(CharSequence charSequence, boolean z, int i, boolean z2) {
        String str = "";
        if (z2 || this.Xb) {
            ((TextView) this.Dfc).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.nn.getRenderRequest().eli() && com.bytedance.sdk.component.adexpress.aGH.MGA.DbA(this.nn.getRenderRequest().aGH())) {
            if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                ((TextView) this.Dfc).setText(i + "s");
            } else {
                ((TextView) this.Dfc).setText(String.format(com.bytedance.sdk.component.utils.ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_full_skip"), Integer.valueOf(i)));
            }
            this.eli = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.aGH.DbA() && !"open_ad".equals(this.nn.getRenderRequest().aGH()) && this.nn.getRenderRequest().eli()) {
            this.Xb = true;
            setVisibility(8);
            return;
        }
        if (!"timedown".equals(this.NU.aAs().DbA())) {
            ((TextView) this.Dfc).setText(((Object) charSequence) + "s");
            this.DbA = true;
            if (this.eli) {
                CharSequence text = ((TextView) this.Dfc).getText();
                if (text != null) {
                    str = text.toString();
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (com.bytedance.sdk.component.adexpress.dynamic.ui.du.DbA(str, this.nlS.ui(), true)[0] + com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.nlS.Os() + this.nlS.aGH())), this.wC);
                layoutParams.gravity = 8388629;
                this.Dfc.setLayoutParams(layoutParams);
                this.eli = false;
                requestLayout();
                return;
            }
            return;
        }
        ((TextView) this.Dfc).setText(charSequence);
    }
}
