package com.bytedance.sdk.openadsdk.nn;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class kb extends aAs {
    public kb(Context context) {
        this(context, null);
    }

    public kb(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public kb(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.nn.aAs
    protected void eli(Context context) {
        int DbA = SSo.DbA(context, 10.0f);
        int DbA2 = SSo.DbA(context, 5.0f);
        int DbA3 = SSo.DbA(context, 16.0f);
        int DbA4 = SSo.DbA(context, 15.0f);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        kbVar.setLayoutParams(layoutParams);
        addView(kbVar);
        this.eli = ui(context);
        this.eli.setId(aqO.QW);
        this.eli.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        kbVar.addView(this.eli);
        this.DbA = MGA(context);
        this.DbA.setId(aqO.Bnk);
        this.DbA.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        kbVar.addView(this.DbA);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar2 = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        kbVar2.setId(aqO.HN);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, SSo.DbA(context, 60.0f));
        layoutParams2.addRule(12);
        kbVar2.setBackgroundColor(Color.parseColor("#26000000"));
        kbVar2.setLayoutParams(layoutParams2);
        kbVar.addView(kbVar2);
        this.Os = kb(context);
        this.Os.setId(aqO.Hm);
        int DbA5 = SSo.DbA(context, 50.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DbA5, DbA5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = DbA4;
        layoutParams3.setMarginStart(DbA4);
        this.Os.setLayoutParams(layoutParams3);
        kbVar2.addView(this.Os);
        this.aGH = DbA(context);
        this.aGH.setId(aqO.vb);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = DbA2;
        layoutParams4.setMarginStart(DbA2);
        layoutParams4.addRule(1, aqO.Hm);
        layoutParams4.addRule(17, aqO.Hm);
        this.aGH.setLayoutParams(layoutParams4);
        kbVar2.addView(this.aGH);
        this.MGA = aGH(context);
        this.MGA.setId(aqO.XxP);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(SSo.DbA(context, 70.0f), SSo.DbA(context, 36.0f));
        layoutParams5.addRule(21);
        layoutParams5.addRule(11);
        layoutParams5.addRule(15);
        layoutParams5.rightMargin = DbA4;
        layoutParams5.setMarginEnd(DbA4);
        this.MGA.setLayoutParams(layoutParams5);
        kbVar2.addView(this.MGA);
        View wC = wC(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(2, aqO.HN);
        layoutParams6.leftMargin = DbA3;
        layoutParams6.bottomMargin = DbA;
        wC.setLayoutParams(layoutParams6);
        kbVar.addView(wC);
    }

    @Override // com.bytedance.sdk.openadsdk.nn.aAs
    protected com.bytedance.sdk.openadsdk.core.ui.wC aGH(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.wC aGH = super.aGH(context);
        aGH.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_download_corner_bg"));
        aGH.setTextSize(2, 14.0f);
        return aGH;
    }

    @Override // com.bytedance.sdk.openadsdk.nn.aAs
    protected com.bytedance.sdk.openadsdk.core.ui.wC DbA(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.wC DbA = super.DbA(context);
        DbA.setGravity(16);
        DbA.setMaxWidth(SSo.DbA(context, 150.0f));
        DbA.setTextColor(Color.parseColor("#B7B7B7"));
        DbA.setTextSize(2, 15.0f);
        DbA.setText("APP NAME");
        return DbA;
    }
}
