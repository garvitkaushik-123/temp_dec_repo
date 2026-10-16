package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class KM extends MGA implements com.bytedance.sdk.component.adexpress.dynamic.Os {
    private boolean eli;

    public KM(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.eli = dynamicRootView.getRenderRequest().NU();
        }
        this.kb = this.wC;
        this.Dfc = new ImageView(context);
        this.Dfc.setTag(Integer.valueOf(getClickArea()));
        addView(this.Dfc, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().ujq()) {
            return;
        }
        this.Dfc.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        Drawable Os;
        super.FC();
        ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable eli = com.bytedance.sdk.component.adexpress.aGH.Os.eli(getContext(), this.nlS);
        if (eli != null) {
            ((ImageView) this.Dfc).setBackground(eli);
        }
        if (this.eli) {
            Os = com.bytedance.sdk.component.utils.ev.Os(getContext(), "tt_close_btn");
        } else {
            Os = com.bytedance.sdk.component.utils.ev.Os(getContext(), "tt_skip_btn");
            if (Os != null) {
                Os.setAutoMirrored(true);
            }
        }
        if (Os != null) {
            ((ImageView) this.Dfc).setImageDrawable(Os);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os
    public void eli(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
