package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class FC extends FrameLayout {
    private dV DbA;
    private String FC;
    private PAGLogoView MGA;
    private TextView Os;
    private boolean aAs;
    private aqO aGH;
    private com.bytedance.sdk.openadsdk.core.DbA.eli du;
    private boolean eli;
    private com.bytedance.sdk.openadsdk.core.ui.wC kb;
    private TextView ui;
    private ev wC;

    public FC(Context context) {
        super(context);
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.aqO.MQ);
    }

    public void eli(ev evVar, String str, com.bytedance.sdk.openadsdk.core.DbA.eli eliVar, boolean z) {
        this.wC = evVar;
        this.FC = str;
        this.aAs = z;
        this.du = eliVar;
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.DbA.eli eliVar) {
        this.du = eliVar;
        TextView textView = this.ui;
        if (textView != null) {
            textView.setOnClickListener(eliVar);
            this.ui.setOnTouchListener(this.du);
        }
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
        this.ui.setOnClickListener(this.du);
        this.ui.setOnTouchListener(this.du);
        String GMu = this.wC.GMu();
        if (!TextUtils.isEmpty(GMu)) {
            this.ui.setText(GMu);
        }
        if (this.DbA != null && this.wC.SjY() != null && !TextUtils.isEmpty(this.wC.SjY().eli())) {
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.wC.SjY(), this.DbA, this.wC);
        }
        aqO aqo = this.aGH;
        if (aqo != null) {
            SSo.eli((TextView) null, aqo, this.wC);
            if (this.wC.pu() != null) {
                this.aGH.setVisibility(0);
            }
        }
        if (this.Os != null) {
            if (this.wC.pu() != null && !TextUtils.isEmpty(this.wC.pu().DbA())) {
                this.Os.setText(this.wC.pu().DbA());
            } else if (!TextUtils.isEmpty(this.wC.kEI())) {
                this.Os.setText(this.wC.kEI());
            } else {
                this.Os.setVisibility(8);
            }
        }
        if (this.kb != null) {
            String Pf = this.wC.Pf();
            if (!TextUtils.isEmpty(Pf)) {
                this.kb.setText(Pf);
            } else {
                this.kb.setVisibility(8);
            }
        }
        this.MGA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.FC.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.eli(FC.this.getContext(), FC.this.wC, FC.this.FC);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void DbA() {
        FrameLayout.LayoutParams layoutParams;
        Context context = getContext();
        boolean z = this.wC.WO() == 1;
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
        this.kb = wCVar2;
        wCVar2.setEllipsize(TextUtils.TruncateAt.END);
        this.kb.setGravity(17);
        this.kb.setMaxLines(2);
        this.kb.setTextColor(Color.parseColor("#BFFFFFFF"));
        this.kb.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = SSo.DbA(context, 8.0f);
        uiVar.addView(this.kb, layoutParams3);
        this.aGH = new aqO(context, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, SSo.DbA(context, 16.0f));
        layoutParams4.topMargin = SSo.DbA(context, 12.0f);
        this.aGH.setVisibility(8);
        uiVar.addView(this.aGH, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar3 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.ui = wCVar3;
        wCVar3.setId(520093707);
        this.ui.setGravity(17);
        this.ui.setText(com.bytedance.sdk.component.utils.ev.eli(context, "tt_video_download_apk"));
        this.ui.setTextColor(-1);
        this.ui.setTextSize(2, 16.0f);
        this.ui.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, SSo.DbA(context, 44.0f));
        layoutParams5.topMargin = SSo.DbA(context, 54.0f);
        uiVar.addView(this.ui, layoutParams5);
        if (!this.aAs && this.wC.gnF() && KM.Os(this.wC)) {
            this.ui.setVisibility(8);
        }
        this.MGA = PAGLogoView.createPAGLogoViewByMaterial(context, this.wC);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, SSo.DbA(context, 14.0f));
        layoutParams6.gravity = 8388691;
        layoutParams6.leftMargin = SSo.DbA(context, 18.0f);
        if (z) {
            layoutParams6.bottomMargin = SSo.DbA(context, 61.0f);
        } else {
            layoutParams6.bottomMargin = SSo.DbA(context, 24.0f);
        }
        addView(this.MGA, layoutParams6);
    }
}
