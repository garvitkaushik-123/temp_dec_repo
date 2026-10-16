package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.MGA.QX;
import com.bytedance.sdk.component.adexpress.MGA.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA extends dV<com.bytedance.sdk.component.adexpress.MGA.MGA> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.dV
    protected void aGH() {
    }

    public MGA(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar, int i, int i2, int i3, JSONObject jSONObject) {
        super(context, uiVar, kbVar);
        this.DbA = context;
        this.aGH = kbVar;
        this.Os = uiVar;
        eli(i, i2, i3, jSONObject, kbVar);
    }

    private void eli(int i, int i2, int i3, JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        int i4;
        this.eli = new com.bytedance.sdk.component.adexpress.MGA.MGA(this.DbA, i, i2, i3, jSONObject);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.DbA, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.DbA;
        if (kbVar.tGZ() > 0) {
            i4 = kbVar.tGZ();
        } else {
            i4 = com.bytedance.sdk.component.adexpress.aGH.DbA() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, i4);
        this.eli.setLayoutParams(layoutParams);
        this.eli.setClipChildren(false);
        this.eli.setSlideText(this.aGH.QI());
        if (this.eli instanceof com.bytedance.sdk.component.adexpress.MGA.MGA) {
            ((com.bytedance.sdk.component.adexpress.MGA.MGA) this.eli).setShakeText(this.aGH.oc());
            final Xb shakeView = ((com.bytedance.sdk.component.adexpress.MGA.MGA) this.eli).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new QX.eli() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Os.MGA.1
                });
                shakeView.setOnClickListener((View.OnClickListener) this.Os.getDynamicClickListener());
            }
        }
    }
}
