package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class du extends FrameLayout {
    private dV DbA;
    private com.bytedance.sdk.openadsdk.core.DbA.eli FC;
    private com.bytedance.sdk.openadsdk.core.ui.wC MGA;
    private TextView Os;
    private aqO aGH;
    private boolean eli;
    private ev kb;
    private PAGLogoView ui;
    private String wC;

    public du(Context context) {
        super(context);
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.aqO.gAc);
    }

    public void eli(ev evVar, String str, com.bytedance.sdk.openadsdk.core.DbA.eli eliVar) {
        this.kb = evVar;
        this.wC = str;
        this.FC = eliVar;
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.DbA.eli eliVar) {
        this.FC = eliVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            eli();
        }
    }

    private void eli() {
        if (this.eli) {
            return;
        }
        this.eli = true;
        DbA();
        if (this.DbA != null && this.kb.SjY() != null && !TextUtils.isEmpty(this.kb.SjY().eli())) {
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.kb.SjY(), this.DbA, this.kb);
        }
        aqO aqo = this.aGH;
        if (aqo != null) {
            SSo.eli((TextView) null, aqo, this.kb);
            if (this.kb.pu() != null) {
                this.aGH.setVisibility(0);
            }
        }
        if (this.Os != null) {
            if (this.kb.pu() != null && !TextUtils.isEmpty(this.kb.pu().DbA())) {
                this.Os.setText(this.kb.pu().DbA());
            } else if (!TextUtils.isEmpty(this.kb.kEI())) {
                this.Os.setText(this.kb.kEI());
            } else {
                this.Os.setVisibility(8);
            }
        }
        if (this.MGA != null) {
            String Pf = this.kb.Pf();
            if (!TextUtils.isEmpty(Pf)) {
                this.MGA.setText(Pf);
            } else {
                this.MGA.setVisibility(8);
            }
        }
        this.ui.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.du.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.eli(du.this.getContext(), du.this.kb, du.this.wC);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void DbA() {
        FrameLayout.LayoutParams layoutParams;
        Context context = getContext();
        boolean z = this.kb.WO() == 1;
        setBackgroundColor(-16777216);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setGravity(1);
        uiVar.setOrientation(1);
        if (z) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(SSo.DbA(context, 327.0f), -2);
        }
        layoutParams.gravity = 17;
        int DbA = SSo.DbA(context, 24.0f);
        layoutParams.rightMargin = DbA;
        layoutParams.leftMargin = DbA;
        addView(uiVar, layoutParams);
        dV dVVar = new dV(context);
        this.DbA = dVVar;
        dVVar.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(SSo.DbA(context, 80.0f), SSo.DbA(context, 80.0f));
        layoutParams2.bottomMargin = SSo.DbA(context, 12.0f);
        uiVar.addView(this.DbA, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.Os = wCVar;
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        this.Os.setGravity(17);
        this.Os.setMaxLines(2);
        this.Os.setMaxWidth(SSo.DbA(context, 180.0f));
        this.Os.setTextColor(-1);
        this.Os.setTextSize(2, 24.0f);
        uiVar.addView(this.Os, new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.MGA = wCVar2;
        wCVar2.setEllipsize(TextUtils.TruncateAt.END);
        this.MGA.setGravity(17);
        this.MGA.setMaxLines(2);
        this.MGA.setTextColor(Color.parseColor("#BFFFFFFF"));
        this.MGA.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = SSo.DbA(context, 8.0f);
        uiVar.addView(this.MGA, layoutParams3);
        this.aGH = new aqO(context, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, SSo.DbA(context, 16.0f));
        layoutParams4.topMargin = SSo.DbA(context, 12.0f);
        this.aGH.setVisibility(8);
        uiVar.addView(this.aGH, layoutParams4);
        this.ui = PAGLogoView.createPAGLogoViewByMaterial(context, this.kb);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, SSo.DbA(context, 14.0f));
        layoutParams5.gravity = 8388691;
        layoutParams5.leftMargin = SSo.DbA(context, 18.0f);
        if (z) {
            layoutParams5.bottomMargin = SSo.DbA(context, 61.0f);
        } else {
            layoutParams5.bottomMargin = SSo.DbA(context, 24.0f);
        }
        addView(this.ui, layoutParams5);
    }
}
