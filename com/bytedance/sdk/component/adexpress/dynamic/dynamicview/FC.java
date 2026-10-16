package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class FC extends MGA {
    public FC(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            this.Dfc = new ImageView(context);
        } else {
            this.Dfc = new com.bytedance.sdk.component.adexpress.MGA.FC(context);
        }
        this.Dfc.setTag(3);
        addView(this.Dfc, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.Dfc);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        super.FC();
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            Drawable eli = com.bytedance.sdk.component.adexpress.aGH.Os.eli(getContext(), this.nlS);
            if (eli != null) {
                this.Dfc.setBackground(eli);
            }
            int aGH = com.bytedance.sdk.component.utils.ev.aGH(getContext(), "tt_close_btn");
            if (aGH > 0) {
                ((ImageView) this.Dfc).setImageResource(aGH);
            }
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int eli2 = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.dV());
        if (this.Dfc instanceof com.bytedance.sdk.component.adexpress.MGA.FC) {
            ((com.bytedance.sdk.component.adexpress.MGA.FC) this.Dfc).setRadius((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.Dfc()));
            ((com.bytedance.sdk.component.adexpress.MGA.FC) this.Dfc).setStrokeWidth(eli2);
            ((com.bytedance.sdk.component.adexpress.MGA.FC) this.Dfc).setStrokeColor(this.nlS.aqO());
            ((com.bytedance.sdk.component.adexpress.MGA.FC) this.Dfc).setBgColor(this.nlS.KM());
            ((com.bytedance.sdk.component.adexpress.MGA.FC) this.Dfc).setDislikeColor(this.nlS.kb());
            ((com.bytedance.sdk.component.adexpress.MGA.FC) this.Dfc).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, 1.0f));
        }
        return true;
    }
}
