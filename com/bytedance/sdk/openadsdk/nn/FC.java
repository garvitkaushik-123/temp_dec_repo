package com.bytedance.sdk.openadsdk.nn;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class FC extends aAs {
    public FC(Context context) {
        this(context, null);
    }

    public FC(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FC(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.nn.aAs
    protected void eli(Context context) {
        int DbA = SSo.DbA(context, 10.0f);
        int DbA2 = SSo.DbA(context, 6.0f);
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
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, SSo.DbA(context, 48.0f));
        layoutParams2.addRule(12);
        kbVar2.setLayoutParams(layoutParams2);
        kbVar2.setBackgroundColor(Color.parseColor("#26000000"));
        kbVar2.setGravity(16);
        kbVar2.setPadding(DbA4, 0, 0, 0);
        kbVar.addView(kbVar2);
        this.Os = kb(context);
        this.Os.setId(aqO.Hm);
        int DbA5 = SSo.DbA(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DbA5, DbA5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = DbA;
        layoutParams3.setMarginStart(DbA);
        this.Os.setLayoutParams(layoutParams3);
        kbVar2.addView(this.Os);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(17, aqO.Hm);
        layoutParams4.addRule(1, aqO.Hm);
        uiVar.setLayoutParams(layoutParams4);
        uiVar.setGravity(16);
        uiVar.setOrientation(1);
        kbVar2.addView(uiVar);
        this.aGH = DbA(context);
        this.aGH.setId(aqO.vb);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(SSo.DbA(context, 130.0f), SSo.DbA(context, 20.0f));
        layoutParams5.leftMargin = DbA2;
        layoutParams5.setMarginStart(DbA2);
        this.aGH.setLayoutParams(layoutParams5);
        uiVar.addView(this.aGH);
        this.ui = Os(context);
        this.ui.setId(aqO.hg);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = DbA2;
        layoutParams6.setMarginStart(DbA2);
        this.ui.setLayoutParams(layoutParams6);
        uiVar.addView(this.ui);
        this.MGA = aGH(context);
        this.MGA.setId(aqO.XxP);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(SSo.DbA(context, 80.0f), SSo.DbA(context, 30.0f));
        layoutParams7.addRule(21);
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        layoutParams7.rightMargin = DbA;
        layoutParams7.setMarginEnd(DbA);
        this.MGA.setLayoutParams(layoutParams7);
        kbVar2.addView(this.MGA);
        View wC = wC(context);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, aqO.HN);
        layoutParams8.leftMargin = DbA3;
        layoutParams8.bottomMargin = DbA;
        wC.setLayoutParams(layoutParams8);
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
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        wCVar.setGravity(16);
        wCVar.setMaxWidth(SSo.DbA(context, 153.0f));
        wCVar.setSingleLine();
        wCVar.setText("Pangle");
        wCVar.setTextColor(-1);
        wCVar.setTextSize(2, 14.0f);
        return wCVar;
    }

    @Override // com.bytedance.sdk.openadsdk.nn.aAs
    protected com.bytedance.sdk.openadsdk.core.ui.wC Os(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.wC Os = super.Os(context);
        Os.setGravity(16);
        Os.setMaxWidth(SSo.DbA(context, 153.0f));
        Os.setTextColor(-1);
        Os.setTextSize(2, 13.0f);
        return Os;
    }
}
