package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.MGA.QX;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Dfc implements kb<com.bytedance.sdk.component.adexpress.MGA.QX> {
    private Context DbA;
    private JSONObject FC;
    private int MGA;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui Os;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.kb aGH;
    private com.bytedance.sdk.component.adexpress.MGA.QX eli;
    private int kb;
    private String ui;
    private int wC;

    public Dfc(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar, String str, int i, int i2, int i3, JSONObject jSONObject) {
        this.DbA = context;
        this.Os = uiVar;
        this.aGH = kbVar;
        this.ui = str;
        this.MGA = i;
        this.kb = i2;
        this.wC = i3;
        this.FC = jSONObject;
        ui();
    }

    private void ui() {
        final com.bytedance.sdk.component.adexpress.dynamic.MGA.eli dynamicClickListener = this.Os.getDynamicClickListener();
        try {
            new JSONObject().put("convertActionType", 1);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.ui)) {
            Context context = this.DbA;
            com.bytedance.sdk.component.adexpress.MGA.QX qx = new com.bytedance.sdk.component.adexpress.MGA.QX(context, com.bytedance.sdk.component.adexpress.Os.eli.wC(context), this.MGA, this.kb, this.wC, this.FC);
            this.eli = qx;
            if (qx.getShakeLayout() != null) {
                this.eli.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.DbA;
            this.eli = new com.bytedance.sdk.component.adexpress.MGA.QX(context2, com.bytedance.sdk.component.adexpress.Os.eli.kb(context2), this.MGA, this.kb, this.wC, this.FC);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eli.setGravity(17);
        layoutParams.gravity = 17;
        this.eli.setLayoutParams(layoutParams);
        this.eli.setTranslationY(com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.DbA, this.aGH.Mc()));
        this.eli.setShakeText(this.aGH.QI());
        this.eli.setClipChildren(false);
        this.eli.setOnShakeViewListener(new QX.eli() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Os.Dfc.1
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void eli() {
        this.eli.eli();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void DbA() {
        this.eli.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.MGA.QX Os() {
        return this.eli;
    }
}
