package com.bytedance.sdk.openadsdk.component.FC;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aqO;
import com.bytedance.sdk.openadsdk.core.widget.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.du;

/* loaded from: classes3.dex */
public class MGA extends Os {
    private final com.bytedance.sdk.openadsdk.core.ui.ui NU;
    private final aqO nn;

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public com.bytedance.sdk.openadsdk.core.ui.aGH getAdIconView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public com.bytedance.sdk.openadsdk.core.ui.wC getAdTitleTextView() {
        return null;
    }

    public MGA(Context context, ev evVar) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#EDFCFF"), Color.parseColor("#FFF6FD")}));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        this.NU = uiVar;
        uiVar.setId(520093758);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = SSo.DbA(context, 24.0f);
        layoutParams.topMargin = SSo.DbA(context, 56.0f);
        uiVar.setLayoutParams(layoutParams);
        uiVar.setClickable(false);
        uiVar.setGravity(16);
        uiVar.setOrientation(0);
        this.MGA = new dV(context);
        this.MGA.setId(520093759);
        this.MGA.setLayoutParams(new LinearLayout.LayoutParams(SSo.DbA(context, 24.0f), SSo.DbA(context, 24.0f)));
        this.kb = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.kb.setId(520093761);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = SSo.DbA(context, 8.0f);
        this.kb.setLayoutParams(layoutParams2);
        this.kb.setEllipsize(TextUtils.TruncateAt.END);
        this.kb.setMaxLines(2);
        this.kb.setTextColor(Color.parseColor("#161823"));
        this.kb.setTextSize(12.0f);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(SSo.DbA(context, 327.0f), -2);
        layoutParams3.addRule(13);
        layoutParams3.leftMargin = SSo.DbA(context, 24.0f);
        layoutParams3.rightMargin = SSo.DbA(context, 24.0f);
        kbVar.setLayoutParams(layoutParams3);
        this.FC = new dV(context);
        this.FC.setId(com.bytedance.sdk.openadsdk.utils.aqO.KUA);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(SSo.DbA(context, 80.0f), SSo.DbA(context, 80.0f));
        layoutParams4.addRule(14);
        this.FC.setLayoutParams(layoutParams4);
        this.aAs = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.aAs.setId(com.bytedance.sdk.openadsdk.utils.aqO.rfG);
        this.aAs.setTextSize(24.0f);
        this.aAs.setTextColor(Color.parseColor("#161823"));
        this.aAs.setGravity(17);
        this.aAs.setMaxLines(1);
        this.aAs.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, com.bytedance.sdk.openadsdk.utils.aqO.KUA);
        layoutParams5.topMargin = SSo.DbA(context, 12.0f);
        layoutParams5.addRule(14);
        this.aAs.setLayoutParams(layoutParams5);
        this.du = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.du.setId(com.bytedance.sdk.openadsdk.utils.aqO.Kv);
        this.du.setTextSize(16.0f);
        this.du.setTextColor(Color.parseColor("#80161823"));
        this.du.setGravity(17);
        this.du.setMaxLines(2);
        this.du.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(3, com.bytedance.sdk.openadsdk.utils.aqO.rfG);
        layoutParams6.topMargin = SSo.DbA(context, 4.0f);
        layoutParams6.addRule(14);
        this.du.setLayoutParams(layoutParams6);
        aqO aqo = new aqO(context);
        this.nn = aqo;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = SSo.DbA(context, 12.0f);
        aqo.setLayoutParams(layoutParams7);
        this.ui = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.ui.setId(520093717);
        this.ui.setBackground(du.eli(context, "tt_reward_full_video_backup_btn_bg"));
        this.ui.setEllipsize(TextUtils.TruncateAt.END);
        this.ui.setLines(1);
        this.ui.setGravity(17);
        this.ui.setTextColor(-1);
        this.ui.setTextSize(16.0f);
        this.ui.setTag("open_ad_click_button_tag");
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, SSo.DbA(context, 44.0f));
        layoutParams8.addRule(3, com.bytedance.sdk.openadsdk.utils.aqO.Kv);
        layoutParams8.topMargin = SSo.DbA(context, 54.0f);
        layoutParams8.addRule(14);
        this.ui.setLayoutParams(layoutParams8);
        this.aGH = PAGLogoView.createPAGLogoViewByMaterial(context, evVar);
        this.aGH.setId(520093757);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, SSo.DbA(context, 14.0f));
        layoutParams9.leftMargin = SSo.DbA(context, 16.0f);
        layoutParams9.bottomMargin = SSo.DbA(context, 24.0f);
        layoutParams9.addRule(12);
        this.aGH.setLayoutParams(layoutParams9);
        addView(this.wC);
        uiVar.addView(this.MGA);
        uiVar.addView(this.kb);
        addView(uiVar);
        kbVar.addView(this.FC);
        kbVar.addView(this.aAs);
        kbVar.addView(this.du);
        kbVar.addView(aqo);
        kbVar.addView(this.ui);
        addView(kbVar);
        addView(this.aGH);
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public View getUserInfo() {
        return this.NU;
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public aqO getScoreBar() {
        return this.nn;
    }
}
