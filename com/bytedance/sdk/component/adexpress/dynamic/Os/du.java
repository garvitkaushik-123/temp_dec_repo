package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.KM;
import com.bytedance.sdk.component.utils.ev;

/* loaded from: classes3.dex */
public class du implements kb<ViewGroup> {
    private final FrameLayout DbA;
    private final com.bytedance.sdk.component.adexpress.MGA.aAs eli;

    public du(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar, String str, String str2) {
        int i;
        com.bytedance.sdk.component.adexpress.MGA.aAs aas = new com.bytedance.sdk.component.adexpress.MGA.aAs(context);
        this.eli = aas;
        aas.setImageLottieTosPath(str);
        FrameLayout frameLayout = new FrameLayout(context);
        this.DbA = frameLayout;
        frameLayout.addView(aas, new FrameLayout.LayoutParams(-2, -2));
        double tLO = kbVar.tLO();
        tLO = tLO == 0.0d ? 1.0d : tLO;
        double gHb = kbVar.gHb();
        double d = gHb != 0.0d ? gHb : 1.0d;
        if ("22".equals(str2)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if ("20".equals(str2)) {
            eli(context, frameLayout, kbVar);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 81;
            if (kbVar.tGZ() > 0) {
                i = kbVar.tGZ();
            } else {
                i = com.bytedance.sdk.component.adexpress.aGH.DbA() ? 0 : 120;
            }
            layoutParams2.bottomMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, i);
            frameLayout.setLayoutParams(layoutParams2);
            frameLayout.setClipChildren(false);
            return;
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (uiVar.getDynamicWidth() * 0.32d * tLO), (int) (uiVar.getDynamicWidth() * 0.32d * d));
        layoutParams3.gravity = 17;
        frameLayout.setLayoutParams(layoutParams3);
    }

    private void eli(Context context, FrameLayout frameLayout, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -KM.eli(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(context.getString(ev.DbA(context, "tt_splash_brush_mask_title")));
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, KM.eli(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText(context.getString(ev.DbA(context, "tt_splash_brush_mask_hint")));
        if (kbVar != null && !TextUtils.isEmpty(kbVar.QI())) {
            textView2.setText(kbVar.QI());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void eli() {
        this.eli.wC();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void DbA() {
        this.eli.MGA();
        ViewParent parent = this.DbA.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.DbA);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public ViewGroup Os() {
        return this.DbA;
    }
}
