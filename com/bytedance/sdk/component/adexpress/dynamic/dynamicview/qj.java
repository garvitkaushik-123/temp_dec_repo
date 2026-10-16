package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class qj extends MGA implements com.bytedance.sdk.component.adexpress.dynamic.ui {
    FrameLayout DbA;
    boolean Xb;
    TextView eli;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    public boolean ui() {
        return true;
    }

    public qj(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.Xb = false;
        this.Dfc = new View(context);
        this.Dfc.setTag(Integer.valueOf(getClickArea()));
        this.eli = new TextView(context);
        this.DbA = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.eli.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.eli.setBackground(gradientDrawable);
        this.eli.setTextSize(10.0f);
        this.eli.setGravity(17);
        this.eli.setTextColor(-1);
        this.eli.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            addView(this.DbA, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.eli);
        addView(this.Dfc, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            addView(this.DbA, getWidgetLayoutParams());
        }
        dynamicRootView.videoView = this.DbA;
        dynamicRootView.setVideoListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        super.FC();
        double d = 0.0d;
        double d2 = 0.0d;
        for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar = this.NU; wCVar != null; wCVar = wCVar.nlS()) {
            d2 = (d2 + wCVar.MGA()) - wCVar.aGH();
            d = (d + wCVar.kb()) - wCVar.ui();
        }
        try {
            float f = (float) d2;
            int eli = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), f);
            int eli2 = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), f + this.ui);
            if (com.bytedance.sdk.component.adexpress.aGH.DbA.eli(getContext())) {
                nGm ngm = (nGm) this.nn.getChildAt(0);
                nGm ngm2 = ngm;
                int dynamicWidth = ngm.getDynamicWidth();
                int i = dynamicWidth - eli2;
                eli2 = dynamicWidth - eli;
                eli = i;
            }
            if (!"open_ad".equals(this.nn.getRenderRequest().aGH())) {
                nGm ngm3 = (nGm) this.nn.getChildAt(0);
                nGm ngm4 = ngm3;
                float f2 = (float) d;
                ngm3.eli.eli(eli, (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), f2), eli2, (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), f2 + this.MGA));
            } else {
                this.nn.videoView = this.DbA;
            }
        } catch (Exception unused) {
        }
        this.nn.updateRenderInfoForVideo(d2, d, this.ui, this.MGA, this.nlS.Dfc());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ui
    public void setTimeUpdate(int i) {
        String str;
        String str2;
        if (this.NU.aAs().ui().OJ() && i > 0 && !this.Xb) {
            if (i >= 60) {
                str = "0" + (i / 60);
            } else {
                str = "00";
            }
            String str3 = str + ":";
            int i2 = i % 60;
            if (i2 <= 9) {
                str2 = str3 + "0" + i2;
            } else {
                str2 = str3 + i2;
            }
            this.eli.setText(str2);
            this.eli.setVisibility(0);
            return;
        }
        this.Xb = true;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            Os(getChildAt(i3));
        }
        this.eli.setVisibility(8);
    }

    private void Os(View view) {
        if (view == this.eli || view == this.QX) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.eli.MGA)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            Os(viewGroup.getChildAt(i));
            i++;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ui
    public void eli() {
        this.eli.setVisibility(8);
    }
}
