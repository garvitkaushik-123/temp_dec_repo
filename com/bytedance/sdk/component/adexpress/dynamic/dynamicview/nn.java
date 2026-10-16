package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class nn extends MGA {
    public nn(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.Dfc = new ImageView(context);
        this.Dfc.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            this.wC = Math.max(dynamicRootView.getLogoUnionHeight(), this.wC);
        }
        addView(this.Dfc, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        super.FC();
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        if (this.nn != null && this.nn.getRenderRequest() != null && !TextUtils.isEmpty(this.nn.getRenderRequest().Ue())) {
            String Ue = this.nn.getRenderRequest().Ue();
            if (Ue.equals("logo")) {
                ((ImageView) this.Dfc).setImageResource(com.bytedance.sdk.component.utils.ev.aGH(getContext(), "tt_ad_logo"));
            } else {
                com.bytedance.sdk.component.ui.aAs ui = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().ui().eli(Ue).eli(this.kb).DbA(this.wC).aGH(this.kb).ui(this.wC);
                String nn = this.nn.getRenderRequest().nn();
                if (!TextUtils.isEmpty(nn)) {
                    ui.DbA(nn);
                }
                ui.eli((ImageView) this.Dfc);
            }
        } else {
            setVisibility(8);
        }
        ((ImageView) this.Dfc).setColorFilter(this.nlS.kb(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
