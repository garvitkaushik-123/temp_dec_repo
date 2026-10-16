package com.bytedance.sdk.openadsdk.nn;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class aGH extends aAs {
    public aGH(Context context) {
        this(context, null);
    }

    public aGH(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public aGH(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.nn.aAs
    protected void eli(Context context) {
        int DbA = SSo.DbA(context, 10.0f);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        uiVar.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        uiVar.setOrientation(1);
        uiVar.setPadding(DbA, DbA, DbA, DbA);
        addView(uiVar);
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 3.0f;
        os.setLayoutParams(layoutParams2);
        uiVar.addView(os);
        this.eli = ui(context);
        this.eli.setId(aqO.QW);
        this.eli.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        os.addView(this.eli);
        this.DbA = MGA(context);
        this.DbA.setId(aqO.Bnk);
        this.DbA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        os.addView(this.DbA);
        PAGLogoView wC = wC(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        layoutParams3.leftMargin = DbA;
        layoutParams3.topMargin = DbA;
        layoutParams3.bottomMargin = DbA;
        wC.setLayoutParams(layoutParams3);
        os.addView(wC);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        kbVar.setLayoutParams(layoutParams4);
        uiVar.addView(kbVar);
        this.Os = kb(context);
        this.Os.setId(aqO.Hm);
        int DbA2 = SSo.DbA(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(DbA2, DbA2);
        layoutParams5.addRule(15);
        this.Os.setLayoutParams(layoutParams5);
        kbVar.addView(this.Os);
        this.aGH = DbA(context);
        this.aGH.setId(aqO.vb);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(15);
        layoutParams6.leftMargin = DbA;
        layoutParams6.setMarginStart(DbA);
        layoutParams6.addRule(1, aqO.Hm);
        layoutParams6.addRule(17, aqO.Hm);
        this.aGH.setLayoutParams(layoutParams6);
        kbVar.addView(this.aGH);
        this.MGA = aGH(context);
        this.MGA.setId(aqO.XxP);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(SSo.DbA(context, 100.0f), SSo.DbA(context, 32.0f));
        layoutParams7.addRule(11);
        layoutParams7.addRule(21);
        layoutParams7.addRule(15);
        this.MGA.setLayoutParams(layoutParams7);
        kbVar.addView(this.MGA);
    }
}
