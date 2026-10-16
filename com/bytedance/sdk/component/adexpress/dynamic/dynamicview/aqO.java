package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class aqO extends MGA implements com.bytedance.sdk.component.adexpress.dynamic.DbA {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    public boolean ui() {
        return true;
    }

    public aqO(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.Dfc = new ImageView(context);
        this.Dfc.setTag(5);
        addView(this.Dfc, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().ujq()) {
            return;
        }
        this.Dfc.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        super.FC();
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.nn.mIsMute);
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            Drawable eli = com.bytedance.sdk.component.adexpress.aGH.Os.eli(getContext(), this.nlS);
            if (eli == null) {
                return true;
            }
            ((ImageView) this.Dfc).setBackground(eli);
            return true;
        }
        ((ImageView) this.Dfc).setBackgroundDrawable(com.bytedance.sdk.component.adexpress.aGH.wC.eli(0, Integer.valueOf(this.nlS.KM()), new int[]{this.wC / 2}, null, null, null));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.DbA
    public void setSoundMute(boolean z) {
        int aGH;
        if (z) {
            aGH = com.bytedance.sdk.component.utils.ev.aGH(getContext(), "tt_reward_full_mute");
        } else {
            aGH = com.bytedance.sdk.component.utils.ev.aGH(getContext(), "tt_reward_full_unmute");
        }
        ((ImageView) this.Dfc).setImageResource(aGH);
        if (((ImageView) this.Dfc).getDrawable() != null) {
            ((ImageView) this.Dfc).getDrawable().setAutoMirrored(true);
        }
    }
}
