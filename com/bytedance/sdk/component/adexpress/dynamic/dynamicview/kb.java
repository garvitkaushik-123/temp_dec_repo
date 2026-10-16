package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class kb extends MGA {
    public kb(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.Dfc = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.eli(context);
        this.Dfc.setTag(Integer.valueOf(getClickArea()));
        addView(this.Dfc, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.bytedance.sdk.component.adexpress.aGH.DbA() && "fillButton".equals(this.NU.aAs().DbA())) {
            ((TextView) this.Dfc).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.Dfc).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.nlS.nGm() * 2;
            widgetLayoutParams.height -= this.nlS.nGm() * 2;
            widgetLayoutParams.topMargin += this.nlS.nGm();
            widgetLayoutParams.leftMargin += this.nlS.nGm();
            widgetLayoutParams.setMarginStart(widgetLayoutParams.leftMargin);
            widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        super.FC();
        if (TextUtils.equals("download-progress-button", this.NU.aAs().DbA()) && TextUtils.isEmpty(this.nlS.aAs())) {
            this.Dfc.setVisibility(4);
            return true;
        }
        this.Dfc.setTextAlignment(this.nlS.wC());
        ((TextView) this.Dfc).setText(this.nlS.aAs());
        ((TextView) this.Dfc).setTextColor(this.nlS.kb());
        ((TextView) this.Dfc).setTextSize(this.nlS.ui());
        ((TextView) this.Dfc).setGravity(17);
        ((TextView) this.Dfc).setIncludeFontPadding(false);
        if ("fillButton".equals(this.NU.aAs().DbA())) {
            this.Dfc.setPadding(0, 0, 0, 0);
        } else {
            this.Dfc.setPadding(this.nlS.Os(), this.nlS.DbA(), this.nlS.aGH(), this.nlS.eli());
        }
        return true;
    }
}
