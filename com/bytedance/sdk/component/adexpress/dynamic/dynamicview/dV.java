package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class dV extends MGA {
    private TextView CMM;
    private TextView DbA;
    private TextView Xb;
    private TextView bf;
    private TextView eli;
    private LinearLayout ev;

    public dV(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.eli = new TextView(this.du);
        this.DbA = new TextView(this.du);
        this.Xb = new TextView(this.du);
        this.ev = new LinearLayout(this.du);
        this.bf = new TextView(this.du);
        this.CMM = new TextView(this.du);
        this.eli.setTag(9);
        this.DbA.setTag(10);
        this.Xb.setTag(12);
        this.ev.addView(this.Xb);
        this.ev.addView(this.CMM);
        this.ev.addView(this.DbA);
        this.ev.addView(this.bf);
        this.ev.addView(this.eli);
        addView(this.ev, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    protected boolean aGH() {
        this.eli.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.eli.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.DbA.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.DbA.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.Xb.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.Xb.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.kb, this.wC);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        this.Xb.setText("Function");
        this.DbA.setText("Permission list");
        this.bf.setText(" | ");
        this.CMM.setText(" | ");
        this.eli.setText("Privacy policy");
        if (this.nlS != null) {
            this.Xb.setTextColor(this.nlS.kb());
            this.Xb.setTextSize(this.nlS.ui());
            this.DbA.setTextColor(this.nlS.kb());
            this.DbA.setTextSize(this.nlS.ui());
            this.bf.setTextColor(this.nlS.kb());
            this.CMM.setTextColor(this.nlS.kb());
            this.eli.setTextColor(this.nlS.kb());
            this.eli.setTextSize(this.nlS.ui());
            return false;
        }
        this.Xb.setTextColor(-1);
        this.Xb.setTextSize(12.0f);
        this.DbA.setTextColor(-1);
        this.DbA.setTextSize(12.0f);
        this.bf.setTextColor(-1);
        this.CMM.setTextColor(-1);
        this.eli.setTextColor(-1);
        this.eli.setTextSize(12.0f);
        return false;
    }
}
