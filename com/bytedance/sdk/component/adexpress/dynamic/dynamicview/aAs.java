package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class aAs extends MGA {
    public aAs(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            this.Dfc = new ImageView(context);
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.kb = this.wC;
        } else {
            this.Dfc = new TextView(context);
        }
        this.Dfc.setTag(3);
        addView(this.Dfc, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.Dfc);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().wC() && dynamicRootView.getRenderRequest().ujq()) {
                return;
            }
            this.Dfc.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        super.FC();
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            Drawable eli = com.bytedance.sdk.component.adexpress.aGH.Os.eli(getContext(), this.nlS);
            if (eli != null) {
                ((ImageView) this.Dfc).setBackground(eli);
            }
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int aGH = com.bytedance.sdk.component.utils.ev.aGH(getContext(), "tt_reward_full_feedback");
            if (aGH > 0) {
                ((ImageView) this.Dfc).setImageResource(aGH);
            }
        }
        return true;
    }
}
