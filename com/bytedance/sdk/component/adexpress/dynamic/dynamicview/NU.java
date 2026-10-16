package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class NU extends MGA {
    public NU(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.Dfc = new TextView(context);
        this.Dfc.setTag(Integer.valueOf(getClickArea()));
        addView(this.Dfc, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        com.bytedance.sdk.component.adexpress.DbA.NU renderRequest;
        super.FC();
        this.Dfc.setTextAlignment(this.nlS.wC());
        ((TextView) this.Dfc).setTextColor(this.nlS.kb());
        ((TextView) this.Dfc).setTextSize(this.nlS.ui());
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            int i = 0;
            ((TextView) this.Dfc).setIncludeFontPadding(false);
            ((TextView) this.Dfc).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), this.wC) - this.nlS.DbA()) - this.nlS.eli()) - 0.5f, this.nlS.ui()));
            if (this.nn != null && (renderRequest = this.nn.getRenderRequest()) != null) {
                String KM = renderRequest.KM();
                if (!TextUtils.isEmpty(KM)) {
                    ((TextView) this.Dfc).setText(KM);
                    ((TextView) this.Dfc).setVisibility(i);
                    return true;
                }
            }
            i = 8;
            ((TextView) this.Dfc).setVisibility(i);
            return true;
        }
        if (eli()) {
            if (com.bytedance.sdk.component.adexpress.dynamic.ui.du.DbA()) {
                ((TextView) this.Dfc).setText(com.bytedance.sdk.component.adexpress.dynamic.ui.du.eli());
                return true;
            }
            ((TextView) this.Dfc).setText(com.bytedance.sdk.component.adexpress.dynamic.ui.du.eli(this.nlS.DbA));
            return true;
        }
        ((TextView) this.Dfc).setText(com.bytedance.sdk.component.utils.ev.DbA(getContext(), "tt_logo_cn"));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    public void MGA() {
        com.bytedance.sdk.component.adexpress.DbA.NU renderRequest = this.nn.getRenderRequest();
        if (renderRequest != null && TextUtils.isEmpty(renderRequest.Ue())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.kb, this.wC);
            layoutParams.gravity = 17;
            setLayoutParams(layoutParams);
            return;
        }
        super.MGA();
    }

    private boolean eli() {
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.nlS.DbA) && this.nlS.DbA.contains("adx:")) || com.bytedance.sdk.component.adexpress.dynamic.ui.du.DbA();
    }
}
