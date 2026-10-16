package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class aAs extends RelativeLayout {
    public aAs(Context context) {
        super(context);
        eli();
    }

    private void eli() {
        Context context = getContext();
        int DbA = SSo.DbA(context, 12.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, SSo.DbA(context, 44.0f)));
        setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setId(520093720);
        agh.setClickable(true);
        agh.setFocusable(true);
        agh.setImageDrawable(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_leftbackicon_selector"));
        int DbA2 = SSo.DbA(context, 24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DbA2, DbA2);
        layoutParams.leftMargin = DbA;
        layoutParams.addRule(15);
        addView(agh, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh2.setId(520093716);
        agh2.setClickable(true);
        agh2.setFocusable(true);
        agh2.setImageDrawable(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_titlebar_close_seletor"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DbA2, DbA2);
        layoutParams2.leftMargin = DbA;
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 520093720);
        addView(agh2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh3 = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh3.setId(com.bytedance.sdk.openadsdk.utils.aqO.XU);
        agh3.setImageDrawable(ev.Os(context, "tt_ad_feedback_new"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DbA2, DbA2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = DbA;
        addView(agh3, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setId(com.bytedance.sdk.openadsdk.utils.aqO.Kp);
        wCVar.setSingleLine(true);
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        wCVar.setGravity(17);
        wCVar.setTextColor(-16777216);
        wCVar.setTextSize(1, 16.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(SSo.DbA(context, 240.0f), -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(1, 520093716);
        layoutParams4.addRule(0, com.bytedance.sdk.openadsdk.utils.aqO.XU);
        int DbA3 = SSo.DbA(context, 25.0f);
        layoutParams4.rightMargin = DbA3;
        layoutParams4.leftMargin = DbA3;
        addView(wCVar, layoutParams4);
    }
}
