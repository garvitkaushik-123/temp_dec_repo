package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class VM extends MGA implements com.bytedance.sdk.component.adexpress.dynamic.Os {
    private boolean eli;

    public VM(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.kb = this.wC;
        this.Dfc = new ImageView(context);
        this.Dfc.setTag(Integer.valueOf(getClickArea()));
        addView(this.Dfc, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            if (!dynamicRootView.getRenderRequest().ujq()) {
                this.Dfc.setVisibility(8);
                setVisibility(8);
            }
            this.eli = dynamicRootView.getRenderRequest().NU();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        Drawable Os;
        super.FC();
        if (this.Dfc != null) {
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.CENTER_CROP);
            Drawable eli = com.bytedance.sdk.component.adexpress.aGH.Os.eli(getContext(), this.nlS);
            if (eli != null) {
                ((ImageView) this.Dfc).setBackground(eli);
            }
            if (this.eli) {
                Os = com.bytedance.sdk.component.utils.ev.Os(getContext(), "tt_close_btn");
            } else {
                Os = com.bytedance.sdk.component.utils.ev.Os(getContext(), "tt_skip_btn");
            }
            if (Os != null) {
                Os.setAutoMirrored(true);
                ((ImageView) this.Dfc).setImageDrawable(Os);
            }
            int eli2 = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.DbA());
            this.Dfc.setPadding(eli2, eli2, eli2, eli2);
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
