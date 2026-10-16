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
public class eli extends aAs {
    public eli(Context context) {
        this(context, null);
    }

    public eli(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public eli(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.nn.aAs
    protected void eli(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        uiVar.setOrientation(1);
        addView(uiVar);
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 337.0f;
        os.setLayoutParams(layoutParams);
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
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 80;
        int DbA = SSo.DbA(context, 10.0f);
        layoutParams2.leftMargin = DbA;
        layoutParams2.topMargin = DbA;
        layoutParams2.bottomMargin = DbA;
        wC.setLayoutParams(layoutParams2);
        os.addView(wC);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 263.0f;
        uiVar2.setLayoutParams(layoutParams3);
        uiVar2.setOrientation(1);
        int DbA2 = SSo.DbA(context, 16.0f);
        uiVar2.setPadding(DbA2, DbA2, DbA2, DbA2);
        uiVar.addView(uiVar2);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        kbVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        uiVar2.addView(kbVar);
        this.Os = kb(context);
        this.Os.setId(aqO.Hm);
        int DbA3 = SSo.DbA(context, 45.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(DbA3, DbA3);
        layoutParams4.rightMargin = DbA;
        layoutParams4.setMarginEnd(DbA);
        this.Os.setLayoutParams(layoutParams4);
        kbVar.addView(this.Os);
        this.aGH = DbA(context);
        this.aGH.setId(aqO.vb);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(1, this.Os.getId());
        layoutParams5.addRule(17, this.Os.getId());
        this.aGH.setLayoutParams(layoutParams5);
        kbVar.addView(this.aGH);
        this.ui = Os(context);
        this.ui.setId(aqO.hg);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(3, this.aGH.getId());
        layoutParams6.addRule(1, this.Os.getId());
        layoutParams6.addRule(17, this.Os.getId());
        this.ui.setLayoutParams(layoutParams6);
        kbVar.addView(this.ui);
        this.MGA = aGH(context);
        this.MGA.setId(aqO.XxP);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, SSo.DbA(context, 32.0f));
        layoutParams7.topMargin = DbA2;
        this.MGA.setLayoutParams(layoutParams7);
        uiVar2.addView(this.MGA);
    }
}
