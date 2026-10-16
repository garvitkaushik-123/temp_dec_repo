package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class FC extends RelativeLayout {
    public FC(Context context) {
        super(context);
        eli();
    }

    private void eli() {
        setId(com.bytedance.sdk.openadsdk.utils.aqO.gHb);
        setBackgroundColor(-1);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, SSo.DbA(context, 44.0f)));
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setId(com.bytedance.sdk.openadsdk.utils.aqO.Mc);
        agh.setClickable(true);
        agh.setFocusable(true);
        agh.setPadding(SSo.DbA(context, 12.0f), SSo.DbA(context, 14.0f), SSo.DbA(context, 12.0f), SSo.DbA(context, 14.0f));
        agh.setImageResource(ev.aGH(context, "tt_ad_xmark"));
        addView(agh, new RelativeLayout.LayoutParams(SSo.DbA(context, 40.0f), SSo.DbA(context, 44.0f)));
        com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh2.setId(com.bytedance.sdk.openadsdk.utils.aqO.GMY);
        agh2.setPadding(SSo.DbA(context, 8.0f), SSo.DbA(context, 10.0f), SSo.DbA(context, 8.0f), SSo.DbA(context, 10.0f));
        agh2.setImageResource(ev.aGH(context, "tt_ad_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SSo.DbA(context, 40.0f), SSo.DbA(context, 44.0f));
        layoutParams.addRule(11);
        addView(agh2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setId(com.bytedance.sdk.openadsdk.utils.aqO.DE);
        wCVar.setSingleLine(true);
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        wCVar.setGravity(17);
        wCVar.setTextColor(Color.parseColor("#222222"));
        wCVar.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(SSo.DbA(context, 191.0f), SSo.DbA(context, 24.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, com.bytedance.sdk.openadsdk.utils.aqO.GMY);
        layoutParams2.addRule(1, com.bytedance.sdk.openadsdk.utils.aqO.Mc);
        int DbA = SSo.DbA(context, 10.0f);
        layoutParams2.leftMargin = DbA;
        layoutParams2.rightMargin = DbA;
        addView(wCVar, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.MGA mga = new com.bytedance.sdk.openadsdk.core.ui.MGA(context, null, R.style.Widget.ProgressBar.Horizontal);
        mga.setId(com.bytedance.sdk.openadsdk.utils.aqO.rH);
        mga.setProgress(1);
        mga.setProgressDrawable(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_privacy_progress_style"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, SSo.DbA(context, 2.0f));
        layoutParams3.addRule(12);
        addView(mga, layoutParams3);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, SSo.DbA(context, 0.5f));
        layoutParams4.addRule(12);
        addView(view, layoutParams4);
    }
}
